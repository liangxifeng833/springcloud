package api.member.servcie.impl;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//@EnableEurekaClient 将当前服务注册到Eureka
@EnableEurekaClient
//开启swagger生成api文档的注解
@EnableSwagger2Doc
public class MemberApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MemberApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MemberApplication.class);
    }

}
