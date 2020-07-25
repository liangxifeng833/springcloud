package configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    //读取git中的配置文件的testUrl值
    @Value("${testUrl}")
    private String testUrl;

    @GetMapping("/getTestUrl")
    public String getTestUrl() {
        return testUrl;
    }
}
