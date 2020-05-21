package lxf.member.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/getMember")
    public String getMember() {
        return "I am member! server port = "+serverPort;
    }
}
