package com.example.GeekScape;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepo userRepo) {
        return args -> {

            UserType kay = new UserType();
            UserType ray = new UserType("rash@gmail.com", "generate2008");
            UserType jay = new UserType("jay@gmail.com", "generate2008");
            UserType raish = new UserType("raishAlgu@gmail.com", "Raish Al", "generate2008");

            userRepo.saveAll(List.of(kay, ray, jay, raish));
        };
    }
}
