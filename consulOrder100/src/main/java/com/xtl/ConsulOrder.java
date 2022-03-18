package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ConsulOrder
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 2:45
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ConsulOrder {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrder.class,args);
    }
}
