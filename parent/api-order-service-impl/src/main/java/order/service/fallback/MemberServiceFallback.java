package order.service.fallback;

import api.common.base.BaseApiService;
import api.common.base.ResponseBase;
import api.member.entity.User;
import order.service.feign.MemberServiceFeign;
import org.springframework.stereotype.Component;

/**
 * 服务降级类
 * 订单order服务访问会员member服务的时候
 * 如果服务超时或者服务雪崩效应出现，会自动实现服务降级
 */
@Component
public class MemberServiceFallback extends BaseApiService implements MemberServiceFeign {
    @Override
    public User getMember(String name) {
        return null;
    }

    //服务降级的友好提示
    @Override
    public ResponseBase getUserInfo() {
        return setResultError("服务器忙，请稍后重试!--以类的方式写的服务降级");
    }
}
