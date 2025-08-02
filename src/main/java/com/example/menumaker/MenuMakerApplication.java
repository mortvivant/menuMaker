package com.example.menumaker;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MenuMakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuMakerApplication.class, args);
    }


    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
