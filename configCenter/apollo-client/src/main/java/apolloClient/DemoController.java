package apolloClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Value("${name:test}")
    String name;

    @GetMapping("apollo")
    public String getName() {
        return name;
    }
}
