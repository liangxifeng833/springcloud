package zuul_gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TmpTestController {
    //从configServce配置中心中获取配置信息path
    @Value("${zuul.routes.api-a.path}")
    private String path;

    @GetMapping("/getPath")
    public String getApiPath() {
        return path;
    }
}
