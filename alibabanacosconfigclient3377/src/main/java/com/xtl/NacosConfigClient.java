package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName NacosConfigClient
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/6 18:23
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClient {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClient.class,args);
    }
}
