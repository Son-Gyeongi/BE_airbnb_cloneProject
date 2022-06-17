package com.sparta.airbnb_clone_be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AirbnbCloneBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirbnbCloneBeApplication.class, args);
    }

}
