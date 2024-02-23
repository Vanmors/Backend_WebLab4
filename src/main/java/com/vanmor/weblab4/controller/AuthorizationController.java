package com.vanmor.weblab4.controller;


import com.vanmor.weblab4.entity.User;
import com.vanmor.weblab4.repository.UserDetailsRepository;
import com.vanmor.weblab4.service.UserService;
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
    private UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/registration")
    public User create(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.create(user);
        return user;
    }
}
