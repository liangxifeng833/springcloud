package configClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient 将当前服务注册到Eureka
@EnableEurekaClient
public class ConfigClientApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ConfigClientApplication.class);
    }
}
