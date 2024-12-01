package com.springrest.course.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import com.springrest.course.entities.User;
import com.springrest.course.dao.UserDao;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {


    @Autowired
    private UserDao userDao;
    // Constructor-based injection for UserDetailsService



    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            // Fetch user from the database using the username
            User user = userDao.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }

            // Return user details including password, roles, etc.
            return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                    .password("{noop}" + user.getPassword()) // Password should be encoded in the DB already
                    .roles(user.getRoleAsString()) // The role fetched from DB, can be "INSTRUCTOR" or "STUDENT"
                    .build();
        };
    }



    // Configure Spring Security to use the UserDetailsService and apply role-based authentication
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF (use with caution, better for stateless applications)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/users/**").permitAll()
                        .requestMatchers("/instructor/**").hasRole("INSTRUCTOR") // INSTRUCTOR role can access /instructor/*
                        .requestMatchers("/student/**").hasRole("STUDENT") // STUDENT role can access /student/*
                        .anyRequest().authenticated() // Any other request requires authentication
                )
                .formLogin(withDefaults()); // Allow everyone to access login page (default login page)

        return http.build();
    }
}
