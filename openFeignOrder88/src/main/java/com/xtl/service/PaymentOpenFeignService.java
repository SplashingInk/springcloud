package com.xtl.service;

import com.xtl.entity.CommonResult;
import com.xtl.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 31925
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentOpenFeignService {

    /**
     *添加订单
     * @param payment 支付订单
     * @return 影响的行数
     */
    @PostMapping("/payment/create")
    CommonResult<Object> create(@RequestBody Payment payment);

    /**
     * 根据id查询订单
     * @param id 订单id
     * @return 返回订单
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    /**
     * 模拟OpenFeign超时
     * @return 服务端口号
     */
    @GetMapping("/payment/openFeignTimeout")
    String openFeignTimeOut();
}
