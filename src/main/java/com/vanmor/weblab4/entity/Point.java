package com.vanmor.weblab4.entity;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Entity(name = "point")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

}
