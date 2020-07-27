package order.service.feign;

import api.member.service.IMemberServcie;
import order.service.fallback.MemberServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
/**
 * 使用feign客户端调用远程会员服务接口
 * 该接口继承会员服务api-member-service中的IMemberService接口
 * 就不需要重复写接口了
 * fallback目的是指定服务降级类
 */
@FeignClient(value = "app-member",fallback = MemberServiceFallback.class)
public interface MemberServiceFeign extends IMemberServcie {
}
