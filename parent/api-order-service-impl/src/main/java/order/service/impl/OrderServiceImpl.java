package order.service.impl;

import api.common.base.ResponseBase;
import api.member.entity.User;
import order.service.IOrderService;
import order.service.feign.MemberServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单服务controller 实现order-service项目中的接口
 */
@RestController
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private MemberServiceFeign memberServiceFeign;


    @RequestMapping("/orderToMember")
    @Override
    public String orderToMember(String name) {
        User user = memberServiceFeign.getMember(name);
        return user==null ? "找不到用户信息" : user.toString();
    }

    @RequestMapping("/orderToMemberUserInfo")
    @Override
    public ResponseBase orderToMemberUserInfo() {
        return memberServiceFeign.getUserInfo();
    }
}
