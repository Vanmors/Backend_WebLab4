package com.vanmor.weblab4.repository;

import com.vanmor.weblab4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailsRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
