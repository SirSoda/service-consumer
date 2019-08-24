package com.yonyou.cloud.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-provider")
public interface HelloService {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
