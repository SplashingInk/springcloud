package com.xtl.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName OpenFeignConfig
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 15:26
 */
@Configuration
public class OpenFeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
