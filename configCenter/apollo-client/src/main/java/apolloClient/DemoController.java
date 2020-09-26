package apolloClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //这里是读取配置中心里面的自定义timeout属性,如果没有查询到timeout默认=test
    @Value("${timeout:test}")
    String name;

    @GetMapping("apollo")
    public String getName() {
        return name;
    }
}
