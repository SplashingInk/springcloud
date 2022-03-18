package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName Payment
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 1:33
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Payment {
    public static void main(String[] args) {
        SpringApplication.run(Payment.class,args);
    }
}
