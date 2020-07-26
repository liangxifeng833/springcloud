package configClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//手动触发刷新本地读取git中配置文件缓存所用
//访问http://127.0.0.1:8102/actuator/refresh接口刷新本地缓存
//注意：请求方式：[post]，请求header:[content-type:application/json]
@RefreshScope
public class TestController {
    //读取git中的配置文件的testUrl值
    @Value("${testUrl}")
    private String testUrl;

    @GetMapping("/getTestUrl")
    public String getTestUrl() {
        return testUrl;
    }
}
