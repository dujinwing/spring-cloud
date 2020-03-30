package cn.dujr.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {

    /**
        zuul过滤器类型一共有4种：
        pre：在 Zuul 按照规则路由到下级服务之前执行。如果需要对请求进行预处理，比如鉴权、限流等，都应考虑在此类 Filter 实现。
        route：这类 Filter 是 Zuul 路由动作的执行者，是 Apache Http Client 或 Netflix Ribbon 构建和发送原始 HTTP 请求的地方，目前已支持 Okhttp。
        post：这类 Filter 是在源服务返回结果或者异常信息发生后执行的，如果需要对返回信息做一些处理，则在此类 Filter 进行处理。
        error：在整个生命周期内如果发生异常，则会进入 error Filter，可做全局异常处理。
    */
    @Override
    public String filterType() {
        //请求预处理
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
