package order.service;

import api.common.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单表接口
 */
public interface IOrderService {
    //订单服务调用会员服务
    @RequestMapping("/orderToMember")
    public String orderToMember(String name);

    //订单服务接口调用会员服务接口的getUserInfo
    @RequestMapping("/orderToMemberUserInfo")
    public ResponseBase orderToMemberUserInfo();
}
