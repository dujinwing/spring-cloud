package cn.dujr.abcde;

import cn.dujr.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface HelloWorld {
    @WebMethod
    String hello(@WebParam(name = "helloParam") String name);

    @WebMethod
    String goodBye();

    @WebMethod
    User getUser(@WebParam(name = "username") String username);
}
