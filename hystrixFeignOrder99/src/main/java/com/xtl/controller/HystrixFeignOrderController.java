package com.xtl.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xtl.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName HystrixFeignOrder99
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 16:50
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbackMethod")
public class HystrixFeignOrderController {

    @Resource
    private HystrixService hystrixService;


    @GetMapping("/consumer/hystrix/payment/ok/{id}")
    String hystrixOk(@PathVariable("id") Integer id){
        return hystrixService.hystrixOk(id);
    }


    @GetMapping("/consumer/hystrix/payment/timeout/{id}")
/*    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })*/
    @HystrixCommand
    String hystrixTimeout(@PathVariable("id") Integer id){
        return hystrixService.hystrixTimeout(id);
    }

    public String hystrixTimeoutHandler(Integer id){
        return "消费者99，对方支付系统繁忙或者自己运行出错，清稍后再试！！";
    }

    public String globalFallbackMethod(){
        return "这是全局降级处理方法";
    }
}
