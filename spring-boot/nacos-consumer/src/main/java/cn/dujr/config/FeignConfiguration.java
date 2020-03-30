package cn.dujr.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
* @description: feign配置类，可在此覆盖FeignClientsConfiguration类默认配置
* @param:
* @return:
* @author: 杜锦荣
* @date: 2020-03-30
*/
@Configuration
public class FeignConfiguration {

    //覆盖配置重写次数
    @Bean
    public Retryer retryer(){
        return new Retryer.Default(100,60 * 1000,5);
    }
}
