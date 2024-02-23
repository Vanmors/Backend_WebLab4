package com.vanmor.weblab4.service;

import com.vanmor.weblab4.DTO.PointDTO;
import com.vanmor.weblab4.repository.PointDetailsRepository;
import com.vanmor.weblab4.entity.Point;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PointService {

    @Autowired
    private final PointDetailsRepository pointDetailsRepository;

    public List<Point> getAllPoints() {
        return pointDetailsRepository.findAll();
    }


    public Point create(PointDTO pointDTO) {
        double x = pointDTO.getX();
        double y = pointDTO.getY();
        double r = pointDTO.getR();
        boolean hit = false;

        if (((x * x + y * y) <= r * r && x <= 0 && y >= 0) ||
                (x - y <= r && x >= 0 && y <= 0) ||
                (2 * y <= r && x <= r && x >= 0 && y >= 0)) {
            hit = true;
        }

        Point point = Point.builder()
                .x(pointDTO.getX())
                .y(pointDTO.getY())
                .r(pointDTO.getR())
                .hit(hit)
                .build();
        return pointDetailsRepository.save(point);
    }

}
