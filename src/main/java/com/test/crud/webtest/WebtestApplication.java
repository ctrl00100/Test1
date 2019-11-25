package com.test.crud.webtest;

import com.test.crud.webtest.util.IdWorker;
import com.test.crud.webtest.util.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class WebtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebtestApplication.class, args);
    }


    @Bean
    public IdWorker idWorkker(){
        return new IdWorker(1, 1);
    }
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }

}
