package com.avizva.app.service;

import com.avizva.app.entity.Users;
import com.avizva.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public Users register(Users user){
        return userRepository.save(user);
    }

    public String verify(Users user){
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword())
                );

        if(authentication.isAuthenticated()){
           return jwtService.generateToken(user.getUsername());
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
