package com.yonyou.cloud.feignclients;

import com.yonyou.commons.feign.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("service-provider")
public interface FeignHelloServiceAdvanced extends HelloService {
}
