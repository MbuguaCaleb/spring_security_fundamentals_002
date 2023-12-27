package com.example.spring_security_fundamentals_002.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/demo")
    public String demo(){

        //getting the logged in user from the Spring Security Context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getAuthorities().forEach(System.out::println);
        return "demo";

    }
}
