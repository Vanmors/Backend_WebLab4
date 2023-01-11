//package com.vanmor.weblab4.DB;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.PersistenceContext;
//import javax.persistence.PersistenceUnit;
//
//@Service
//public class CustomUserService implements UserDetailsService {
////    @PersistenceContext
////    private EntityManager em;
//
//    @Autowired
//    UserDetailsRepos userDetailsRepos;
////
////    @Autowired
////    PasswordEncoder passwordEncoder;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        User user = userDetailsRepos.findByUserName(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with userName " + username);
//        }
//        return user;
//    }
//
////    public boolean saveUser(User user) {
////        User userFromDB = userDetailsRepos.findByUserName(user.getUsername());
////
////        if (userFromDB != null) {
////            return false;
////        }
////
////        user.setPassword(passwordEncoder.encode(user.getPassword()));
////        userDetailsRepos.save(user);
////        return true;
////    }
//}
