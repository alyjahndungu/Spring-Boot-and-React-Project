package com.config;

import com.entities_auth.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {
    private String username;
    private String password;
    private String authority;

    public MyUserDetails(User user) {
        this.authority="ROLE_USER";
        this.username = user.getEmail();
        this.password = user.getPassword();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(authority));
    }

    @Transactional
    public String getPassword() {
        return password;
    }

    @Transactional
    public String getUsername() {
        return username;
    }

    @Transactional
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transactional
    public boolean isAccountNonLocked() {
        return true;
    }

    @Transactional
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
