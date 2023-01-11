package com.vanmor.weblab4.security;


//import com.vanmor.weblab4.DB.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;


@EnableWebSecurity(debug = true)
public class Configuration extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private CustomUserService userService;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //In-memory
////        auth.inMemoryAuthentication().withUser("Vanmor").password(passwordEncoder().encode("1234")).authorities("admin");
//
//        //DB auth
//        //auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests().anyRequest().authenticated();
        http.formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/");
        http.httpBasic();
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource){
        UserDetails user = User.builder().username("user").password(passwordEncoder().encode("gg")).roles("USER").build();
        UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("gg")).roles("USER", "ADMIN").build();

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        if (jdbcUserDetailsManager.userExists(user.getUsername())){
            jdbcUserDetailsManager.deleteUser(user.getUsername());
        }
        if (jdbcUserDetailsManager.userExists(admin.getUsername())){
            jdbcUserDetailsManager.deleteUser(admin.getUsername());
        }

        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);
        return jdbcUserDetailsManager;
    }
}
