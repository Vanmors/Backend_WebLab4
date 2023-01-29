package com.vanmor.weblab4;


//import com.vanmor.weblab4.DB.User;
//import com.vanmor.weblab4.DB.UserDetailsRepos;

//
import com.vanmor.weblab4.DB.PointDetailsRepository;
import com.vanmor.weblab4.DB.PointService;
//import com.vanmor.weblab4.DB.User;
import com.vanmor.weblab4.DB.User;
import com.vanmor.weblab4.DB.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin
public class SetData {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private PointDetailsRepository pointDetailsRepository;

    @Autowired
    PointService pointService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping
    @CrossOrigin
    public Point getPoint(@RequestBody Point point) {
        long count = pointDetailsRepository.count();
        point.setId(count + 1);
        pointDetailsRepository.save(point);
        return point;
    }



    @GetMapping("/getAll")
    public List<Point> getAllPoints(){
        return pointService.getAllPoints();
    }



    
    @PostMapping(value = "/registration")
    public void saveUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        long count = userDetailsRepository.count();
        user.setId(count + 1);
        userDetailsRepository.save(user);
    }



}
