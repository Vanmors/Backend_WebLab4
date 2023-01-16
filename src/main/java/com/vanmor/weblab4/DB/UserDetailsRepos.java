package com.vanmor.weblab4.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailsRepos extends JpaRepository<User, Long> {

    User findByUserName(String userName);
}
