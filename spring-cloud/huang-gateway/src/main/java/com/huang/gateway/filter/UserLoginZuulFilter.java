package com.huang.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * create by Mr.huang
 * 666
 * 666
 */
@Component
public class UserLoginZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; //设置过滤器类型为pre
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;//该过滤器是否要执行
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            currentContext.setSendZuulResponse(false);//过滤该请求，不进行路由转发
            currentContext.setResponseStatusCode(401);//设置响应状态码
            currentContext.setResponseBody("token is empty!");
            return null;
        }
        return null;
    }
}
