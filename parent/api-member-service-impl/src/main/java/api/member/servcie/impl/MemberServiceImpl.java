package api.member.servcie.impl;

import api.common.base.BaseApiService;
import api.common.base.ResponseBase;
import api.member.entity.User;
import api.member.service.IMemberServcie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员接口实现,注意：实现的是api.member.servcie项目中的api接口
 */
@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberServcie {
    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/")
    public String index() {
        return "我是会员服务,port="+serverPort;
    }

    @Override
    @GetMapping("/getMember")
    public User getMember(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name+serverPort);
        user.setAge(20);
        return user;
    }

    @GetMapping("/getUserInfo")
    @Override
    public ResponseBase getUserInfo() {
        try {
            //会员服务接口产生1.5秒的延迟
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return setResultSuccess("调用会员服务接口成功...");
    }
}
