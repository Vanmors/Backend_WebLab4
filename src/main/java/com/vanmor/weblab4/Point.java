package com.vanmor.weblab4;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Entity(name = "points")
@NoArgsConstructor
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "x")
    private Integer x;
    @Column(name = "y")
    private Double y;
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
