package com.xtl.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xtl.customer.CustomerExceptionHandler;
import com.xtl.entity.CommonResult;
import com.xtl.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RateLimitController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 0:29
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult<Payment> byResource(){
        return new CommonResult<>(200,"按照资源名称限流测试OK",new Payment(10L,"1314520"));
    }

    public CommonResult<Payment> handleException(BlockException exception){
        return new CommonResult<>(200,exception.getClass().getCanonicalName()+"\t 服务暂不开用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<Payment> byUrl(){
        return new CommonResult<>(200,"按照URL限流测试OK",new Payment(25L,"563214"));
    }

    @GetMapping("/rateLimit/customerBlockHandle")
    @SentinelResource(value = "customerBlockHandle",
                    blockHandlerClass = CustomerExceptionHandler.class,
                    blockHandler = "customerExceptionHandler")
    public CommonResult<Payment> customerBlockHandle(){
        return new CommonResult<>(200,"用户自定义限流测试OK",new Payment(25L,"563214"));
    }

}
