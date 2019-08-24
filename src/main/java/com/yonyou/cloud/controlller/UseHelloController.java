package com.yonyou.cloud.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UseHelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    // 方式一：自己手动实现负载均衡 其实是一种客户端的负载均衡 从eureka中获取服务列表 然后在选某一服务进行调用
    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("loadBalanced")
    private RestTemplate loadBalanced;


    int count;

    // 方式一：自己手动实现负载均衡 其实是一种客户端的负载均衡 从eureka中获取服务列表 然后在选某一服务进行调用
    @GetMapping("/useHello")
    public String useHello(String name) {
        List<ServiceInstance> list = discoveryClient.getInstances("service-provider");
        ServiceInstance instance = list.get(count % list.size());
        count++;
        String host = instance.getHost();
        int port = instance.getPort();
        String s = restTemplate.getForObject("http://" + host + ":" + port + "/hello?name={1}", String.class, host + ":" + port + "--" + name);
        return s;
    }

    // 方式二：在resttemplate上添加loadbalanced注解
    @GetMapping("/useHello2")
    public String useHello2(String name) {
        String s = loadBalanced.getForObject("http://service-provider/hello?name={1}", String.class, name);
        return s;
    }

}
