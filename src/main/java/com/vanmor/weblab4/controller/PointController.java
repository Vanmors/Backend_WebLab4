package com.vanmor.weblab4.controller;

import com.vanmor.weblab4.DTO.PointDTO;
import com.vanmor.weblab4.service.PointService;
import com.vanmor.weblab4.entity.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Point> create(@RequestBody PointDTO pointDTO) {
        return new ResponseEntity<>(pointService.create(pointDTO), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Point> getAllPoints() {
        return pointService.getAllPoints();
    }

}
