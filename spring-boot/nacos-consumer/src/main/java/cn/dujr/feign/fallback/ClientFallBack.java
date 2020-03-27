package cn.dujr.feign.fallback;

import cn.dujr.entity.User;
import cn.dujr.feign.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClientFallBack implements Client {
    @Override
    public String hello(String name) {
        return (String)returnError(name);
    }

    @Override
    public User sayHello(User user) {
        return (User)returnError(user);
    }

    public Object returnError(Object obj){
        log.error("调用服务失败，入参为：" + obj.toString());
        return obj;
    }
}
