package order.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("member-service")
public interface MemberServiceFeign {
    @GetMapping("/getUser")
    String getUser(@RequestParam Integer userId);
}
