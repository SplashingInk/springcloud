package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName OpenFeignOrder
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 14:46
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignOrder {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOrder.class,args);
    }
}
