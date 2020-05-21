package eureka.springcloudeurekaservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
// @EnableEurekaServer 代表启动Eureka注册中心服务端
@EnableEurekaServer
public class SpringcloudEurekaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaServiceApplication.class, args);
    }
}
