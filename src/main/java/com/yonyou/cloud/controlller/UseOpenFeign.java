package com.yonyou.cloud.controlller;

import com.yonyou.cloud.feignclients.FeignHelloService;
import com.yonyou.cloud.feignclients.FeignHelloServiceAdvanced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UseOpenFeign {

    @Autowired(required = false)
    private FeignHelloService helloService;

    @Autowired(required = false)
    private FeignHelloServiceAdvanced helloServiceAdvanced;

    @GetMapping("/useFeign")
    public String useFeign(String name) {
        return helloService.hello(name);
    }

    @GetMapping("/useFeignAdvanced")
    public String useFeignAdvanced(String name) {
        return helloServiceAdvanced.hello(name);
    }
}
