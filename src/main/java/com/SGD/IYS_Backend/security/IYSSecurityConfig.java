package com.SGD.IYS_Backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class IYSSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList<>();
        users.add(new User(
                "Abhi",
                passwordEncoder().encode("Pass@123"),
                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))
        ));

        users.add(new User("user2",passwordEncoder().encode("Pass2@123")
                ,Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));

        return new InMemoryUserDetailsManager(users);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
