package lxf.order.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderApiController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getOrder")
    public String getOrder(){
        //两种方式调用member服务接口，一种是直接通过member ipd地址调用，另一种是通过注册中心获取member的ip地址然后调用
        //String res = restTemplate.getForObject("http://127.0.0.1:8000/getMember",String.class);
        //使用别名的方式请求member服务接口
        String res = restTemplate.getForObject("http://zk-member/getMember",String.class);
        System.out.println("订单服务调用会员服务getMember结果res="+res);
        return res;
    }

    /**
     * 可以获取服务中心的服务列表等数据
     * @return
     */
    @RequestMapping("/discoveryClientMember")
    public List<ServiceInstance> discoveryClientMember() {
        List<ServiceInstance> instance = discoveryClient.getInstances("zk-member");
        for (ServiceInstance serviceInstance : instance) {
            System.out.println("zk-member url:"+serviceInstance.getUri());
        }
        return instance;
    }
}
