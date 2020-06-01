package order.service.feign;

import api.member.entity.User;
import api.member.service.IMemberServcie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用feign客户端调用远程会员服务接口
 * 该接口继承会员服务api-member-service中的IMemberService接口
 * 就不需要重复写接口了
 */
@FeignClient("app-member")
public interface MemberServiceFeign extends IMemberServcie {
}
