package com.xtl.controller;

import com.xtl.entity.CommonResult;
import com.xtl.entity.Payment;
import com.xtl.service.PaymentOpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName OpenFeignOrderController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 14:53
 */
@Slf4j
@RestController
public class OpenFeignOrderController {

    @Resource
    public PaymentOpenFeignService paymentOpenFeignService;

    @PostMapping("/consumer/payment/create")
    CommonResult<Object> create(@RequestBody Payment payment){
        return paymentOpenFeignService.create(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentOpenFeignService.getPaymentById(id);
    }


    @GetMapping("/consumer/payment/openFeignTimeout")
    String openFeignTimeOut(){
        //OpenFeign默认等待1秒钟
        return paymentOpenFeignService.openFeignTimeOut();
    }
}
