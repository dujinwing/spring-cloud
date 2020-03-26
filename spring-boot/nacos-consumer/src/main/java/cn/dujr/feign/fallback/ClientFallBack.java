package cn.dujr.feign.fallback;

import cn.dujr.feign.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ClientFallBack implements Client {
    @Override
    public String hello(String name) {
        log.error("调用服务失败，入参为：{}",name);
        return "调用失败：" + name;
    }
}
