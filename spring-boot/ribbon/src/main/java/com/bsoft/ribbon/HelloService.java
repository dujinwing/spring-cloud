package com.bsoft.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hello(String name){
        return restTemplate.getForObject("http://EUREKA-CLIENT/test?name="+name,String.class);
    }

    public String hiError(String name){
        return name +" sorry! this is  error";
    }
}
