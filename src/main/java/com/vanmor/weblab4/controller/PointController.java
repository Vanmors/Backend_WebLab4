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
    PointService pointService;

    @PostMapping
    @CrossOrigin
    public Point create(@RequestBody Point point) {
        pointService.create(point);
        return point;
    }

    @GetMapping("/getAll")
    public List<Point> getAllPoints() {
        return pointService.getAllPoints();
    }

}
