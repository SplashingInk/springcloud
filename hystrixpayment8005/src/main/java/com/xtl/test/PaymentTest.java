package com.xtl.test;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentTest
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 15:59
 */
@Component
public class PaymentTest {
    public String hystrixOk(Integer id){
        return "线程池："+Thread.currentThread().getName()+"payment hystrix_ok id:"+id;
    }

    @HystrixCommand(fallbackMethod = "hystrixTimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String hystrixTimeout(Integer id){
        int timeout=3;
        try{
             TimeUnit.SECONDS.sleep(timeout);
        }catch(InterruptedException e){
          e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"payment hystrix_timeout id:"+id+"耗时（秒）"+timeout;
    }

    public String hystrixTimeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+"payment hystrix_timeout id:"+id+"系统繁忙，清稍后再试！！";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw new RuntimeException("id不是是负数");
        }
        String serialNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t 调用成功，流水号为："+serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id")  Integer id){
        return "id不能为负数，清稍后再试~~~,id:"+id;
    }
}
