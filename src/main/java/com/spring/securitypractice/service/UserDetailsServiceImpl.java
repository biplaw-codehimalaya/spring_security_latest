package com.spring.securitypractice.service;

import com.spring.securitypractice.config.SecurityUser;
import com.spring.securitypractice.entity.User;
import com.spring.securitypractice.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepo.findByUsername(username);

        if(foundUser == null){
            throw  new UsernameNotFoundException("Bad Credentials.");
        }
        return new SecurityUser(foundUser);
    }
}
