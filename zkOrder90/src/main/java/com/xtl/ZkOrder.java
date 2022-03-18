package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName ZkOrder
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 2:06
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ZkOrder {
    public static void main(String[] args) {
        SpringApplication.run(ZkOrder.class,args);
    }
}
