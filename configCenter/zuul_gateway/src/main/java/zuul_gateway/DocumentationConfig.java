package zuul_gateway;

import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * zuul整合swagger所用类
 * 添加文档来源吗
 */
@Component
@Primary
public class DocumentationConfig implements SwaggerResourcesProvider {
    private final RouteLocator routeLocator;

    public DocumentationConfig(RouteLocator routeLocator) {
        this.routeLocator = routeLocator;
    }

    /**
     * 配置所有的微服务
     *
     * @return
     */
/*    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        List<Route> routes = routeLocator.getRoutes();
        routes.forEach(route -> {
            resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"), "1.0"));
        });
        return resources;
    }*/

    /**
     * 配置特定的微服务
     * @return
     */
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        resources.add(swaggerResource("会员服务", "/api-member/v2/api-docs", "1.0"));
        resources.add(swaggerResource("订单服务", "/api-order/v2/api-docs", "1.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
