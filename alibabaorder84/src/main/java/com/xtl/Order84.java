package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName Order96
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/6 17:58
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Order84 {
    public static void main(String[] args) {
        SpringApplication.run(Order84.class, args);
    }
}
