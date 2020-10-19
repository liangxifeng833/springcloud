package zuul_gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
/**
 * 网关token过滤器
 * @author liangxifeng
 * @date 2020-08-09
 */
//@Component
public class TokenFilter extends ZuulFilter {
    @Value("${server.port}")
    private String serverPort;
    //过滤器类型pre,表示请求之前执行
    @Override
    public String filterType() {
        return "pre";
    }

    //过滤器执行顺序,当一个请求在同一阶段存在多个过滤器的时候,多个过滤器执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    //判断过滤器是否生效,这里return true生效
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 拦截业务逻辑代码
     * 所有通过网关的请求,都必须通过该方法验证,才能继续放行
     * 如果验证失败,则返回401
     */
    @Override
    public Object run() throws ZuulException {
        //案例:拦截所有服务接口,判断服务接口上是否有传递userToken参数
        //1. 获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //2. 获取Request
        HttpServletRequest request = currentContext.getRequest();
        //3. 获取token
        String userToken = request.getParameter("userToken");
        if (StringUtils.isEmpty(userToken)) {
            //如果token为空,则网关直接返回
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("userToken is null");
            currentContext.setResponseStatusCode(401);
            return null;
        }
        System.out.println("网关服务器端口号="+serverPort);
        //正常调用其他服务接口
        return null;
    }
}
