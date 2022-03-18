package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName Order
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/4 16:34
 */
@EnableEurekaClient
@SpringBootApplication
public class Order {
    public static void main(String[] args) {
        SpringApplication.run(Order.class,args);
    }
}
