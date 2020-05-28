package lxf.order.api.feign;

import lxf.order.api.DomainResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * 请求远程member服务feign接口
 */
//app-member就是会员服务注册到Eureka的服务别名
@FeignClient(name="app-member")
public interface MemberApiFeign {

    //需要请求member服务的getMember方法
    @GetMapping("/getMember")
    public String getFeignMember();

    //需要请求member服务的addMember方法
    @PostMapping("/addMember")
    public DomainResponse addFeignMember(@RequestBody Map<String,Object> map);
}
