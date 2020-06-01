package api.member.service;

import api.member.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义会员接口
 */
public interface IMemberServcie {
    @RequestMapping("/getMember")
    public User getMember(@RequestParam("name") String name) ;
}
