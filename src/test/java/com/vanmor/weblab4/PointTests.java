package com.vanmor.weblab4;

import com.vanmor.weblab4.DTO.PointDTO;
import com.vanmor.weblab4.service.PointService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PointTests {


    @Autowired
    PointService pointService;

    @Test
    public void testPointInsideCircleAndUpperHalf() {
        assertTrue(pointService.create(new PointDTO(-1.0, 1.0, 2.0)).getHit());
    }

    @Test
    public void testPointOnCircleLineAndRightHalf() {
        assertTrue(pointService.create(new PointDTO(1.0, -1.0, 2.0)).getHit());
    }

    @Test
    public void testPointOnSecondQuarterBorder() {
        assertFalse(pointService.create(new PointDTO(-1.0, -1.0, 2.0)).getHit());
    }

    @Test
    public void testPointInsideCircleAndRightUpperQuarter() {
        assertTrue(pointService.create(new PointDTO(1.0, 1.0, 2.0)).getHit());
    }

    @Test
    public void testPointOnFirstQuarterBorder() {
        assertFalse(pointService.create(new PointDTO(2.0, 2.0, 2.0)).getHit());
    }

    @Test
    public void testPointOutsideCircleAndFourthQuarter() {
        assertFalse(pointService.create(new PointDTO(3.0, -1.0, 2.0)).getHit());
    }

    @Test
    public void testPointOnBorderXEqualRAndYEqualZero() {
        assertTrue(pointService.create(new PointDTO(2.0, 0.0, 2.0)).getHit());
    }

    @Test
    public void testPointOnBorderXEqualZeroAndYEqualR() {
        assertTrue(pointService.create(new PointDTO(0.0, 2.0, 2.0)).getHit());
    }

}
