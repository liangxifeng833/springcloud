package order.service.impl;

import api.common.base.BaseApiService;
import api.common.base.ResponseBase;
import api.member.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import order.service.IOrderService;
import order.service.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 订单服务controller 实现order-service项目中的接口
 */
@RestController
@Api(tags = "订单服务接口")
public class OrderServiceImpl extends BaseApiService implements IOrderService {
    @Autowired
    private MemberServiceFeign memberServiceFeign;
    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/")
    public String index() {
        return "我是订单服务,port="+serverPort;
    }


    @ApiOperation("获取订单接口")
    @PostMapping("/getOrder")
    public String getOrder()
    {
        return "我订单服务getOrder方法";
    }

    @GetMapping("/orderToMember")
    @Override
    public String orderToMember(String name) {
        User user = memberServiceFeign.getMember(name);
        return user==null ? "找不到用户信息" : user.toString();
    }

    //没有解决服务雪崩效应
    @GetMapping("/orderToMemberUserInfo")
    @Override
    public ResponseBase orderToMemberUserInfo() {
        return memberServiceFeign.getUserInfo();
    }

    /**
     * 解决服务雪崩效应
     * 该方法中 memberServiceFeign.getUserInfo() 有1.5秒的延时
     * 已经超出了hystrix默认延时时间1秒，所以调用该方法时候会返回orderToMemberUserInfoHystrixFallback结果
     * 可以在application.yml中配置关闭hystrix超时时间：hystrix.command.default.execution.timeout.enabled=false
     * 如果在高并发情况下访问该接口:
     *  比如同时2万个并发,该接口只处理10个请求,便终止提示友好信息;
     *  因为Hystrix默认熔断阈值=10,超过该值便终止请求.但是此时其他orderInfo()接口依然可以正常访问,因为他们不在同一个线程池中.
     *
     * @HystrixCommand 默认开启服务隔离（使用线程隔离方式）：
     *                  比如：以下orderToMemberUserInfoHystrix()方法被线程池hystrix-OrderServiceImpl处理
     *                       以下orderInfo()方法被线程池hystrix-OrderServiceImpl处理
     *                 默认开启服务降级执行，本例执行方法是："orderToMemberUserInfoHystrixFallback"
     *                 默认开启服务熔断机制
     *                 fallbackMethod()方法的作用是：服务降级执行
     * @return
     */
    @HystrixCommand(fallbackMethod = "orderToMemberUserInfoHystrixFallback")
    @GetMapping("/orderToMemberUserInfoHystrix")
    public ResponseBase orderToMemberUserInfoHystrix() {
        //输出：orderToMemberUserInfoHystrix-线程池名称：hystrix-OrderServiceImpl-1
        System.out.println("orderToMemberUserInfoHystrix-线程池名称："+Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo(); //getUserInfo()有1.5秒的延时
    }

    /**
     * Hystrix第二种写法,使用类方式实现服务降级
     * @return
     */
    @GetMapping("/orderToMemberUserInfoHystrix_demo02")
    public ResponseBase orderToMemberUserInfoHystrixDemo02() {
        //输出：orderToMemberUserInfoHystrix-线程池名称：hystrix-OrderServiceImpl-1
        System.out.println("orderToMemberUserInfoHystrix-线程池名称："+Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo(); //getUserInfo()有1.5秒的延时
    }

    public ResponseBase orderToMemberUserInfoHystrixFallback() {
        return setResultSuccess("返回一个友好的提示：服务降级，服务器忙，请稍后重试!");
    }

    //订单服务接口
    @GetMapping("/orderInfo")
    @Override
    public ResponseBase orderInfo() {
        //输出：orderInfo-线程池名称：http-nio-8103-exec-7
        System.out.println("orderInfo-线程池名称："+Thread.currentThread().getName());
        return setResultSuccess();
    }
}
