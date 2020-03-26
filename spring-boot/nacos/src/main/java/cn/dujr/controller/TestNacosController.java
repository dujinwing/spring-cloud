package cn.dujr.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestNacosController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello(String name){
        return "hello " + name + "！this is from port:" + port;
    }
}
