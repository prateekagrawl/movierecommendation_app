package com.example.movierecommendation.config;

import com.example.movierecommendation.domain.MyUser;
import com.example.movierecommendation.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MyAuthorityProvider implements AuthenticationProvider {

    @Autowired
    MyUserService myUserService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //creds entered by user
        String userName = authentication.getName();
        String userPassword = authentication.getCredentials().toString();

        //creds from db
        UserDetails myUser = myUserService.loadUserByUsername(userName);

        //compare creds using password encoder
        if(myUser!=null && passwordEncoder.matches(userPassword,myUser.getPassword()))
            return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),authentication.getCredentials(),myUser.getAuthorities());
        throw new BadCredentialsException("Invalid Credentials");

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
