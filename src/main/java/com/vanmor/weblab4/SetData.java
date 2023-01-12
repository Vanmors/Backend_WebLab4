package com.vanmor.weblab4;


//import com.vanmor.weblab4.DB.User;
//import com.vanmor.weblab4.DB.UserDetailsRepos;
import com.vanmor.weblab4.DB.PointDetailsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;


@RestController
@RequestMapping("/")
@CrossOrigin
public class SetData {


    @Autowired
    private PointDetailsRepos pointDetailsRepos;

//    @GetMapping(value = "/hello", consumes = {"application/json"})
    @GetMapping
    @CrossOrigin
    public Point getPoint(@RequestBody Point point){
        System.out.println("I'm here");
//        System.out.println(point);
        point.setHit(((point.getX() * point.getX() + point.getY() * point.getY()) <= point.getR() * point.getR() && point.getX() <= 0 && point.getY() >= 0) ||
                (point.getY() + point.getX() <= point.getR() && point.getX() >= 0 && point.getY() <= 0) ||
                (point.getY() / 2 >= (point.getX() - point.getR() / 2) && point.getX() >= 0 && point.getY() >= 0));
        pointDetailsRepos.save(point);
        return point;
    }


}
