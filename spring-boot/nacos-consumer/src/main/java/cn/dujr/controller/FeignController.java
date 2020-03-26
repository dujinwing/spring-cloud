package cn.dujr.controller;

import cn.dujr.feign.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 通过Feign调用服务
 * @author: 杜锦荣
 * @date: 2020-03-26
 */
@RestController
@Slf4j
public class FeignController {
    @Autowired
    private Client client;

    @GetMapping("/consumeByFeign")
    public String consumeByFeign(String name) {
        log.info("请求参数----》{}", name);
        return client.hello(name);
    }
}
