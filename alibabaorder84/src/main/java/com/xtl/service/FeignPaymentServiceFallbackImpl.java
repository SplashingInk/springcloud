package com.xtl.service;

import com.xtl.entity.CommonResult;
import com.xtl.entity.Payment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentServiceFallback
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 12:09
 */
@Component
public class FeignPaymentServiceFallbackImpl implements FeignPaymentService {

    @Override
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
        return new CommonResult<>(2333,"服务降级返回，PaymentServiceFallbackImpl",new Payment(id,"errorSerial"));
    }
}
