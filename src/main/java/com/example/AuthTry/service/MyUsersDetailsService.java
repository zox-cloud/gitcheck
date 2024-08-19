package com.example.AuthTry.service;

import com.example.AuthTry.entity.Users;
import com.example.AuthTry.repo.UserRepo;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUsersDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> users = userRepo.findByUsername(username);
        return users.map(MyUsersDetails::new).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
    }
}
