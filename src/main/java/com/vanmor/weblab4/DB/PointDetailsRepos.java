package com.vanmor.weblab4.DB;

import com.vanmor.weblab4.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface PointDetailsRepos extends JpaRepository<Point, Long> {

}
