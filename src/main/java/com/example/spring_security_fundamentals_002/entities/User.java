package com.example.spring_security_fundamentals_002.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;

    //A Set is a  collection that contains no duplicate elements.
    //A user will have many authorities
    //three tables -->User, Authorities and USER_AUTHORITIES
    //The below implementation will return a list of users with authorites specifically for them
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities",
            joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authorities;

}
