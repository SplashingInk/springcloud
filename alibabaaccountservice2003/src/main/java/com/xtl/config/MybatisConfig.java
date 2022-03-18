package com.xtl.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisConfig
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 17:22
 */
@Configuration
@MapperScan("com.xtl.dao")
public class MybatisConfig {

}
