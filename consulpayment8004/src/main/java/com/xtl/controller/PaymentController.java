package com.xtl.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 1:35
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "spring cloud with consul serverPort:"+serverPort+"\t "+ UUID.randomUUID().toString();
    }
}
