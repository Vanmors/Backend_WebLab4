package com.vanmor.weblab4;


//import com.vanmor.weblab4.DB.User;
//import com.vanmor.weblab4.DB.UserDetailsRepos;

//
import com.vanmor.weblab4.DB.PointDetailsRepos;
import com.vanmor.weblab4.DB.PointService;
//import com.vanmor.weblab4.DB.User;
import com.vanmor.weblab4.Entities.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin
public class SetData {


    @Autowired
    private PointDetailsRepos pointDetailsRepos;

    @Autowired
    PointService pointService;


    //    @GetMapping(value = "/hello", consumes = {"application/json"})
    @PostMapping
//    @GetMapping
    @CrossOrigin
    public Point getPoint(@RequestBody Point point) {
        System.out.println("I'm here");
        long count = pointDetailsRepos.count();
        point.setId(count + 1);
        System.out.println(point.getX());
        System.out.println(point.getY());
        System.out.println(point.getR());
        point.setHit(((point.getX() * point.getX() + point.getY() * point.getY()) <= point.getR() * point.getR() && point.getX() <= 0 && point.getY() >= 0) ||
                (point.getY() + point.getX() <= point.getR() && point.getX() >= 0 && point.getY() <= 0) ||
                (point.getY() / 2 >= (point.getX() - point.getR() / 2) && point.getX() >= 0 && point.getY() >= 0));
        System.out.println(point.getHit());
        pointDetailsRepos.save(point);
        return point;
    }

        @GetMapping("/getAll")
    public List<Point> getAllPoints(){
        return pointService.getAllPoints();
    }



}
