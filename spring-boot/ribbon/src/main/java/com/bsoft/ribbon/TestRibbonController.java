package com.bsoft.ribbon;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRibbonController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "testRibbon")
    public String testRibbon(@RequestParam String name){
        return helloService.hello(name);
    }

}
