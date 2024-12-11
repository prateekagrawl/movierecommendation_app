package com.example.movierecommendation.service;

import com.example.movierecommendation.domain.MyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//service to get the details from the db
@Service
public class MyUserService implements UserDetailsService {

    Map<String,UserDetails> userMap = new HashMap<>();
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMap.getOrDefault(username, new MyUser());
    }

    public void addUser(MyUser user){
        this.userMap.put(user.getUsername(),user);
    }
}
