package lxf.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableEurekaClient 将当前服务注册到Eureka
@EnableEurekaClient
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    //手动将RestTemplate加入的bean中
    @Bean
    //如果使用rest方式以别名方式进行调用,则依赖ribbon负载均衡器@LoadBalanced
    //让RestTemplate请求时拥有客户端负载均衡能力
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
