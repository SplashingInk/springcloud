package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName Payment
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/4 15:01
 */
@EnableEurekaClient
@SpringBootApplication
public class Payment {
    public static void main(String[] args) {
        SpringApplication.run(Payment.class,args);
    }
}
