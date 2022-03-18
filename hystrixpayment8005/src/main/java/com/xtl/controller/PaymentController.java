package com.xtl.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xtl.test.PaymentTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 16:03
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    public PaymentTest paymentTest;

    @Value("${server.port}")
    public String serverPort;

    @GetMapping("/hystrix/payment/ok/{id}")
    public String hystrixOk(@PathVariable("id") Integer id){
        String result=paymentTest.hystrixOk(id);
        log.info("结果："+result);
        return result;
    }

    @GetMapping("/hystrix/payment/timeout/{id}")
    public String hystrixTimeout(@PathVariable("id") Integer id){
        String result=paymentTest.hystrixTimeout(id);
        log.info("结果："+result);
        return result;
    }

    @GetMapping("/hystrix/payment/circuitBreaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result=paymentTest.paymentCircuitBreaker(id);
        log.info("结果："+result);
        return result;
    }

}
