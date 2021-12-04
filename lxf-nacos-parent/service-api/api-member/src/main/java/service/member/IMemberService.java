package service.member;

import org.springframework.web.bind.annotation.GetMapping;

public interface IMemberService {
    @GetMapping("/getUser")
    String getUser(Integer userId);
}
