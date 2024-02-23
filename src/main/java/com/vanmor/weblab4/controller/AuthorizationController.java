package com.vanmor.weblab4.controller;


import com.vanmor.weblab4.entity.User;
import com.vanmor.weblab4.repository.UserDetailsRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AuthorizationController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/registration")
    public User create(@RequestBody User user) {
        System.out.println(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        userDetailsRepository.save(user);
        return user;
    }
}
