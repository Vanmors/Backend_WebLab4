package com.vanmor.weblab4;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Entity
@NoArgsConstructor
public class Point {

//    @Id
//    @GeneratedValue
    private Integer id;
    private Integer x;
    private Double y;
    private Integer r;
    private Boolean out;

    public Point(Integer x, Double y, Integer r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }


}
