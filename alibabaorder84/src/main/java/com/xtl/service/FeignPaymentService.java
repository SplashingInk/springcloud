package com.xtl.service;

import com.xtl.entity.CommonResult;
import com.xtl.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 31925
 */
@FeignClient(value = "nacos-payment-service",fallback = FeignPaymentServiceFallbackImpl.class)
public interface FeignPaymentService {

    /**
     * 根据id查询数据
     * @param id id
     * @return  数据
     */
    @GetMapping("/paymentSql/{id}")
    CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
