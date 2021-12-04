package service.member;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberService implements IMemberService{
    @Value("${server.port}")
    private Integer port;
    public String getUser(@RequestParam Integer userId) {
        return "我是会员服务,端口="+port;
    }
}
