package com.vanmor.weblab4.DB;

import com.vanmor.weblab4.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointService {

    @Autowired
    private PointDetailsRepository pointDetailsRepository;

    public List<Point> getAllPoints() {
        return pointDetailsRepository.findAll();
    }

}
