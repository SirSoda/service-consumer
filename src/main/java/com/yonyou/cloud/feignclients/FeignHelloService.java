package com.yonyou.cloud.feignclients;

import com.yonyou.commons.feign.HelloService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient("service-provider")
public interface FeignHelloService {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name") String name);
}
