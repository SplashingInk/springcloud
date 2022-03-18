package com.xtl.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 31925
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-PROVIDER",fallback = HystrixServiceFallbackImpl.class)
public interface HystrixService {
    /**
     * 测试hystrix正常
     * @param id id
     * @return 测试信息
     */
    @GetMapping("/hystrix/payment/ok/{id}")
    String hystrixOk(@PathVariable("id") Integer id);

    /**
     * 测试hystrix超时
     * @param id id
     * @return 测试信息
     */
    @GetMapping("/hystrix/payment/timeout/{id}")
    String hystrixTimeout(@PathVariable("id") Integer id);
}
