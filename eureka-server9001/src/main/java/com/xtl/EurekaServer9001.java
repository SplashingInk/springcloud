package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaServer
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/4 17:27
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer9001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer9001.class,args);
    }
}
