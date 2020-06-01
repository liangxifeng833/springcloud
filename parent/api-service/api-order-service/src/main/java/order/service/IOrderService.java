package order.service;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 订单表接口
 */
public interface IOrderService {
    //订单服务调用会员服务
    @RequestMapping("/orderToMember")
    public String orderToMember(String name);
}
