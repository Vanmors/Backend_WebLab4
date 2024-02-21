package com.vanmor.weblab4.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Entity(name = "point_test")
@NoArgsConstructor
public class Point {

    @Id
    private Long id;
    @Max(5)
    @Min(-3)
    @Column(name = "x")
    private Double x;
    @Max(3)
    @Min(-3)
    @Column(name = "y")
    private Double y;
    @Max(5)
    @Min(-3)
    @Column(name = "r")
    private Double r;
    @Column(name = "hit")
    private Boolean hit;

    public Point(Double x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }


}
