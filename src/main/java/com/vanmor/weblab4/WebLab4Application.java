package com.vanmor.weblab4;

//import com.vanmor.weblab4.DB.User;
//import com.vanmor.weblab4.DB.UserDetailsRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaRepositories
public class WebLab4Application {

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private UserDetailsRepos userDetailsRepos;
    
    public static void main(String[] args) {
        SpringApplication.run(WebLab4Application.class, args);
    }

//    @PostConstruct
//    protected void init(){
//        User user = new User();
//
//        user.setUserName("Nate");
//        user.setPassword(passwordEncoder.encode("1234"));
//        user.setEnabled(true);
//
//        userDetailsRepos.save(user);
//
//    }


}
