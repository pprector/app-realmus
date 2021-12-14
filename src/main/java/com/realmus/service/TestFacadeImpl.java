package com.realmus.service;


import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestFacadeImpl {
    @RequestMapping("/test")
    public User test() {
        User user = new User();
        user.age = "13";
        user.name= "测试";
        return user;
    }

    @Data
    public class User {
        private String name;
        private String age;
    }
}
