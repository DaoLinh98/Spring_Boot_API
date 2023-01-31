package com.restapi.user.controller;

import com.restapi.user.entity.Account;
import com.restapi.user.entity.ERole;
import com.restapi.user.entity.Role;
import com.restapi.user.jwt.JwtTokenProvider;
import com.restapi.user.payload.request.LoginRequest;
import com.restapi.user.payload.request.SignupRequest;
import com.restapi.user.payload.response.JwtResponse;
import com.restapi.user.payload.response.MessageResponse;
import com.restapi.user.security.CustomUserDetails;
import com.restapi.user.service.AccountService;
import com.restapi.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/auth")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private AccountService accountService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/signup")
    public ResponseEntity<?> registerAccount(@RequestBody SignupRequest request){
        if(accountService.exitsByUserName(request.getUserName().toString())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: is already"));
        }

        Account account = new Account();
        account.setUserName(request.getUserName());
        account.setPassWord(passwordEncoder.encode(request.getPassWord()));
        account.setActive(request.isActive());

        Set<String> strRole = request.getListRole();
        Set<Role> listRole = new HashSet<>();

        if(strRole ==null){
            Role userRole = roleService.findByRoleName(ERole.ROLE_USER).orElseThrow(()->new RuntimeException("error:Role is not found"));
            listRole.add(userRole);
        }
        else {
            strRole.forEach(role->{
                switch (role){
                    case "admin":
                        Role adminRole = roleService.findByRoleName(ERole.ROLE_ADMIN)
                                .orElseThrow(()->new RuntimeException("role is not found"));
                        listRole.add(adminRole);
                        break;
                    case "moderator":
                        Role moderatorRole = roleService.findByRoleName(ERole.ROLE_MODERATOR)
                                .orElseThrow(()->new RuntimeException("role is not found"));
                        listRole.add(moderatorRole);
                        break;
                    case "user":
                        Role userRole = roleService.findByRoleName(ERole.ROLE_USER)
                                .orElseThrow(()->new RuntimeException("role is not found"));
                        listRole.add(userRole);
                        break;
                }

            });
        }
        account.setListRoles(listRole);
        accountService.saveOrUpdate(account);
        return ResponseEntity.ok(new MessageResponse("account register successfully"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> loginAccount(@RequestBody LoginRequest loginRequest){
        Authentication authentication =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassWord())

        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetails customUserDetail = (CustomUserDetails) authentication.getPrincipal();
        String jwt = tokenProvider.generateToken(customUserDetail);
        List<String> listRole = customUserDetail.getAuthorities().stream()
                .map(item -> item.getAuthority()).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(jwt,customUserDetail.getUserId(),customUserDetail.getUsername(),
                listRole));
    }


}