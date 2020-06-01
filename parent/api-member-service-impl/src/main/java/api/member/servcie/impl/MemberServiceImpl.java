package api.member.servcie.impl;

import api.member.entity.User;
import api.member.service.IMemberServcie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 会员接口实现,注意：实现的是api.member.servcie项目中的api接口
 */
@RestController
public class MemberServiceImpl implements IMemberServcie {

    @Override
    @RequestMapping("/getMember")
    public User getMember(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name);
        user.setAge(20);
        return user;
    }
}
