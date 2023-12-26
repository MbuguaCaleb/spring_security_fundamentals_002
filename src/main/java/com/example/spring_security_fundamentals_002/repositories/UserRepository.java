package com.example.spring_security_fundamentals_002.repositories;

import com.example.spring_security_fundamentals_002.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u  from User u where u.username =:username")
    Optional<User> findUserByUsername(String username);
}
