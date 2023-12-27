package com.example.spring_security_fundamentals_002.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table( name = "authorities")
@Getter
@Setter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

}
