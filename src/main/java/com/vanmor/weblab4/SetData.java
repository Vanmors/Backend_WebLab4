package com.vanmor.weblab4;


//import com.vanmor.weblab4.DB.User;
//import com.vanmor.weblab4.DB.UserDetailsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;


@RestController
@RequestMapping("/")
@CrossOrigin
public class SetData {


//    @GetMapping(value = "/hello", consumes = {"application/json"})
    @GetMapping
    @CrossOrigin
    public Point getPoint(@RequestBody Point point){
        System.out.println("I'm here");
//        System.out.println(point);
        return point;
    }


}
