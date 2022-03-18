package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName SentinelService
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/6 22:48
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelService {
    public static void main(String[] args) {
        SpringApplication.run(SentinelService.class,args);
    }
}
