package com.restapi.user.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restapi.user.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private int userId;
    private String userName;
    @JsonIgnore
    private String passWord;
    private boolean isActive;
    private Collection<? extends GrantedAuthority> authorities;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    //map from account to userdetail
    public static CustomUserDetails mapAccountToUserDetail(Account account) {
        //lay cac quyen tu account
        List<GrantedAuthority> listAuthorities = account.getListRoles().stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getRoleName().name()))
                .collect(Collectors.toList());
        //tra ve doi tuong CustomUserDetail
        return new CustomUserDetails(
                account.getId(),
                account.getUserName(),
                account.getPassWord(),
                account.isActive(),
                listAuthorities
        );
    }
    @Override
    public String getPassword() {
        return this.passWord;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}