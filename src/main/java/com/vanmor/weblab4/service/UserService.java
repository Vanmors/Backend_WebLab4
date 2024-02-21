package com.vanmor.weblab4.service;

import com.vanmor.weblab4.repository.UserDetailsRepository;
import com.vanmor.weblab4.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private UserDetailsRepository userDetailsRepository;

    @Autowired
    public void setUserDetailsRepos(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }


    public User findByUsername(String username) {
        return userDetailsRepository.findByUserName(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDetailsRepository.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with userName " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), Authority());
    }


    private Collection<? extends GrantedAuthority> Authority() {

        Set<GrantedAuthority> authorities = new HashSet<>(1);
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return authorities;
    }

}
