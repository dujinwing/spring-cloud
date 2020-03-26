package cn.dujr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: FeignClient注解需指定调用服务名
 * @author: 杜锦荣
 * @date: 2020-03-26
 */
@FeignClient(value = "${service.hello.name}")
public interface Client {
    
    /** 
    * @description: 此处虽定义为get请求，若参数不使用@RequestParams声明，feign会默认使用post方法请求原服务
    * @param: [hello] 
    * @return: java.lang.String 
    * @author: 杜锦荣
    * @date: 2020-03-26 
    */ 
    @GetMapping("/hello")
    String hello(@RequestParam("name") String hello);
}
