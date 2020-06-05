package cn.dujr.config;

import cn.dujr.abcde.HelloWorld;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private HelloWorld helloWorld;

    /**
     * 注入servlet
     * @return
     */
    @Bean(name = "cxfServlet")
    public ServletRegistrationBean cxfServlet() {
        // 设置webservice路径为/webservice/
        return new ServletRegistrationBean(new CXFServlet(),"/webservice/*");
    }


    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    /**
     * 注册WebServiceDemoService接口到webservice服务
     * @return
     */
    @Bean(name = "WebServiceDemoEndpoint")
    public Endpoint sweptPayEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), helloWorld);
        // 发布服务   这个服务的路径就是 http://localhost:8099/webservice/webservice?wsdl
        endpoint.publish("/hello");
        return endpoint;
    }
}
