package com.bsoft.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
@Component
public class MyFilter extends ZuulFilter {
   // private static Logger logger = LoggerFactory.getLogger(MyFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        Object token = request.getParameter("token");
        if(token == null){
            System.out.println("token is empty");
            try {
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(401);
                requestContext.getResponse().getWriter().write("we're sorry that you have no right to visit this interface!");
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return null;
        }
        System.out.println("ok");
        return null;



    }
}
