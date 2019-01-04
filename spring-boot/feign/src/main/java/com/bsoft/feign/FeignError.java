package com.bsoft.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignError implements  FeignInterface{
    public String sayHiFromFeign(String name){
        return name +" sorry,this is Feign error";
    }
}
