package cn.dujr.controller;

import cn.dujr.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TestNacosController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello(String name){
        return "hello " + name + "！this is from port:" + port;
    }

    @PostMapping("/sayHello")
    public User sayHello(@RequestBody User user){
        user.setPort(new Integer(port));
        user.setCreateDate(new Date());
        return user;
    }
}
