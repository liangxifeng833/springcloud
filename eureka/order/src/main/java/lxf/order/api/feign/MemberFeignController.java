package lxf.order.api.feign;

import lxf.order.api.DomainResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用feign客户端远程请求member服务的get和post请求测试
 */
@RestController
public class MemberFeignController {
    @Autowired
    private MemberApiFeign memberApiFeign;

    @RequestMapping("/feignMember")
    public DomainResponse feignMember() {
        //测试get请求
        //return memberApiFeign.getFeignMember();
        //测试post请求
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("lan","php");
        map.put("db","mysql");
        DomainResponse res = memberApiFeign.addFeignMember(map);
        System.out.println("response  = " + res);
        return res;
    }
}
