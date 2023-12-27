package com.example.spring_security_fundamentals_002.security;

import com.example.spring_security_fundamentals_002.entities.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

//i am overriding granted authorities from spring boot, to get authorities from my entity
//Granted Authority is a single instance of authority and must take this structure.
@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Authority authority;

    //Will be having the name of each authority from my entity
    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
