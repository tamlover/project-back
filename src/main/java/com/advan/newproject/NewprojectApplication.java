package com.advan.newproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class NewprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewprojectApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String hello() {
        return "hello";
    }
}
