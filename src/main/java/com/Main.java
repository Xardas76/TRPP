package com;

import com.controlers.FrontController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = FrontController.class)
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
}
