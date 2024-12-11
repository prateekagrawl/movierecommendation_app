package com.example.movierecommendation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


@Configuration
public class SecurityConfiguration {

    private final String ADMIN_AUTH="admin";
    private final String USER_AUTH="user";


    @Bean
    public PasswordEncoder getMyPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance(); //to get the object of NoOpPasswordEncoder
    }


    //for authorization
    @Bean  //for authorization
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        /*
         *CSRF -> Cross-Site request forgery
         * XSS -> Cross-site Script
         *
         *
         * */

        /**
         * antMatchers will accept the path and regex after it or the direct path for single api
         *Ex: localhost:8080/main/greet
         * following antmatchers will work
         *  /main/greet**
         *  /main/**
         *  **greet**
         *
         * */
        httpSecurity
                .csrf().disable() //***csrf needs to be disabled if directly hitting POST api from unknown sources
                .authorizeRequests()
                .requestMatchers("/admin/**").hasAuthority(ADMIN_AUTH)
                .requestMatchers("/user/**").hasAuthority(USER_AUTH)
//                .antMatchers("/signup").permitAll()
//                .antMatchers("/**").permitAll()
                .and().formLogin();
//                .and().oauth2Login();
        return httpSecurity.build();
    }
}
