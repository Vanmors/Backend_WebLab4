package com.vanmor.weblab4.DB;

import com.vanmor.weblab4.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointDetailsRepository extends JpaRepository<Point, Long> {

}
