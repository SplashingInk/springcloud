package com.xtl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName SeataOrderService
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 17:35
 */
@SpringBootApplication(exclude ={ DataSourceAutoConfiguration.class})
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderService {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderService.class,args);
    }
}
