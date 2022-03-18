package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName ConfigCenter
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 23:51
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenter {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenter.class,args);
    }
}
