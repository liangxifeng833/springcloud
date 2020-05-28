package lxf.member.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MemberApiController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/getMember")
    public String getMember() {
        return "I am member! server port = "+serverPort;
    }

    @PostMapping("/addMember")
    public DomainResponse addMember(@RequestBody Map<String,Object> map) {
        return DomainResponse.ofSuccess(map);
    }
}
