package com.restapi.user.controller;


import com.restapi.user.entity.Account;
import com.restapi.user.service.AccountService;
import com.restapi.user.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/v1")
public class AccountController {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AccountService accountService;

    @PostMapping( "/login")
    public ResponseEntity<String> login(HttpServletRequest request, @RequestBody Account account) {
        String result = "";
        HttpStatus httpStatus = null;
        try{
            if(accountService.checkLogin(account)) {
                result = jwtService.generateTokenLogin(account.getEmail());
                httpStatus = HttpStatus.OK;
            }else {
                result = "Wrong user and password";
                httpStatus = HttpStatus.BAD_REQUEST;
            }
        }catch (Exception ex){
            result = "Sever Error";
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(result, httpStatus);
    }
}
