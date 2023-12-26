package com.example.spring_security_fundamentals_002.services;

import com.example.spring_security_fundamentals_002.entities.User;
import com.example.spring_security_fundamentals_002.repositories.UserRepository;
import com.example.spring_security_fundamentals_002.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


//The user details service will be Querying users that have been stored in our database, then return UserDetails
@AllArgsConstructor
@Service
public class JPAUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    //What will be in the SpringContext is the username from our Database
    //The implementation we have in our method will override the default
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userByUsername = userRepository.findUserByUsername(username);

        //for us to map our user into a User that spring can understand, we need the user details contract.
        //UserDetails is a class from spring security where our custom user is mapped into the spring security standard

        return userByUsername
                .map(SecurityUser::new)
                .orElseThrow(()->new UsernameNotFoundException("Username not Found" + username));
    }
}
