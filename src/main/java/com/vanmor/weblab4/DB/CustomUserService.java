package com.vanmor.weblab4.DB;

import com.vanmor.weblab4.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserService implements UserDetailsService {
//    @PersistenceContext
//    private EntityManager em;

    private UserDetailsRepos userDetailsRepos;

    @Autowired
    public void setUserDetailsRepos(UserDetailsRepos userDetailsRepos){
        this.userDetailsRepos = userDetailsRepos;
    }



//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public void setUserDetailsRepos(PasswordEncoder passwordEncoder){
//        this.passwordEncoder = passwordEncoder;
//    }

    public User findByUsername(String username){
        return userDetailsRepos.findByUserName(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDetailsRepos.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with userName " + username);
//            userDetailsRepos.save(user);
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), Authority());
    }


    private Collection<? extends GrantedAuthority> Authority(){

        Set<GrantedAuthority> authorities = new HashSet<>(1);
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        return authorities;
    }

//    public boolean saveUser(User user) {
//        User userFromDB = userDetailsRepos.findByUserName(user.getUserName());
//
//        if (userFromDB != null) {
//            return false;
//        }
//
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userDetailsRepos.save(user);
//        return true;
//    }
}
