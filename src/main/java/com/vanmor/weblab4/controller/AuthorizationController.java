package com.vanmor.weblab4.controller;


import com.vanmor.weblab4.entity.User;
import com.vanmor.weblab4.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AuthorizationController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping(value = "/registration")
    public void saveUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        long count = userDetailsRepository.count();
        user.setId(count + 1);
        userDetailsRepository.save(user);
    }
}
