package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName HystrixFeignOrder
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 16:39
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class HystrixFeignOrder {
    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignOrder.class,args);
    }
}
