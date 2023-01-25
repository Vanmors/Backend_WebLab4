package com.vanmor.weblab4;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity(name = "point_test")
@NoArgsConstructor
public class Point {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id = System.nanoTime();
    private Long id;
    @Max(5)
    @Min(-3)
    @Column(name = "x")
    private Integer x;
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

    public Point(Integer x, Double y, Double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }


}
