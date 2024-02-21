package com.vanmor.weblab4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
public class WebLab4Application {
    public static void main(String[] args) {
        SpringApplication.run(WebLab4Application.class, args);
    }

}
