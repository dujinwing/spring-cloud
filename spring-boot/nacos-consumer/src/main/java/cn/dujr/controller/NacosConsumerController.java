package cn.dujr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
* @description: 通过restTemplate调用服务
* @author: 杜锦荣
* @date: 2020-03-26
*/
@RestController
public class NacosConsumerController {

    @Value("${service.hello.name}")
    private String helloServiceName;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/consumeNacos")
    public String consume(String name){
        ServiceInstance instance =  loadBalancerClient.choose(helloServiceName);
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(instance.getUri() + "/hello?name=" + name, String.class);

        return result;
    }

}
