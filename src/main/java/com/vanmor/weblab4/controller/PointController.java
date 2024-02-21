package com.vanmor.weblab4.controller;

import com.vanmor.weblab4.repository.PointDetailsRepository;
import com.vanmor.weblab4.service.PointService;
import com.vanmor.weblab4.entity.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
@CrossOrigin
public class PointController {

    @Autowired
    private PointDetailsRepository pointDetailsRepository;

    @Autowired
    PointService pointService;

    @PostMapping
    @CrossOrigin
    public Point getPoint(@RequestBody Point point) {
        long count = pointDetailsRepository.count();
        point.setId(count + 1);
        pointDetailsRepository.save(point);
        return point;
    }

    @GetMapping("/getAll")
    public List<Point> getAllPoints() {
        return pointService.getAllPoints();
    }

}
