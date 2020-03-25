package cn.dujr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "EUREKA-CLIENT",fallback = FeignError.class)
@Component
public interface FeignInterface {
    @RequestMapping(value="/test",method = RequestMethod.GET)
    String sayHiFromFeign(@RequestParam(value="name") String name);
}
