package apolloClient;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient 将当前服务注册到Eureka
@EnableEurekaClient
//启用apollo客户端
@EnableApolloConfig
public class ApolloClientApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ApolloClientApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApolloClientApplication.class);
    }
}
