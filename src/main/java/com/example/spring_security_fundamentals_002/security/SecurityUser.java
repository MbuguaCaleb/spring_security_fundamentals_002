package com.example.spring_security_fundamentals_002.security;

import com.example.spring_security_fundamentals_002.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


//Decorator Pattern of mapping our Custom User to the UserDetails spring security class.
//Decorator pattern is one of the ways that one class can be mapped into another
//We must map our custom user class into a class that spring can understand.

@AllArgsConstructor
public class SecurityUser implements UserDetails {

    private final User user;

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities()
                .stream()
                .map(SecurityAuthority::new)
                .toList();
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
