package com.xtl.customer;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xtl.entity.CommonResult;
import com.xtl.entity.Payment;

/**
 * @ClassName CustomerExceptionHandler
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 0:52
 */
public class CustomerExceptionHandler {

    public static CommonResult<Payment> customerExceptionHandler(BlockException exception){
        return new CommonResult<>(444,exception.getClass().getCanonicalName());
    }
}
