package com.yonyou.cloud.controlller;

import com.yonyou.cloud.feignclients.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UseOpenFeign {

    @Autowired
    private HelloService helloService;

    @GetMapping("/useFeign")
    public String useFeign(String name) {
        return helloService.hello(name);
    }
}
