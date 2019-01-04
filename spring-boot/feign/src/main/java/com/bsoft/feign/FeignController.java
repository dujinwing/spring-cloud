package com.bsoft.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    FeignInterface feignInterface;

    @RequestMapping(value="testFeign")
    public String sayHi(@RequestParam(value = "name") String name){
        return feignInterface.sayHiFromFeign(name);
    }

}
