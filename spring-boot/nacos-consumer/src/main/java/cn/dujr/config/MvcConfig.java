package cn.dujr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
* @description: spring mvc配置类，配置跨域请求接口地址与来源
* @author: 杜锦荣
* @date: 2020-03-27
*/

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    //注入前端端口号
    @Value("${frontend.port}")
    private String port;

    /**
    * @description: 配置跨域允许请求地址与来源
    * @author: 杜锦荣
    * @date: 2020-03-27
    */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://127.0.0.1:" + port);
    }
}
