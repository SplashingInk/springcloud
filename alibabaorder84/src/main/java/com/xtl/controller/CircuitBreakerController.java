package com.xtl.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.xtl.entity.CommonResult;
import com.xtl.entity.Payment;
import com.xtl.service.FeignPaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/6 18:01
 */
@Slf4j
@RestController
public class CircuitBreakerController {

    private static final String SERVICE_URL="http://nacos-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private FeignPaymentService feignPaymentService;

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandlerFallback",exceptionsToIgnore =IllegalArgumentException.class )
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSql/" + id, CommonResult.class, id);
        if(id==4L){
            throw new IllegalArgumentException("非法参数异常");
        }else if(id==5L) {
            throw new ArrayIndexOutOfBoundsException("此次参数越界！！");
        }else{
                assert result != null;
                if(result.getData()==null){
                    throw new NullPointerException("没有找到对应的记录");
                }
        }
        return result;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id") Long id,Throwable throwable){
        Payment payment = new Payment(id, null);
        return new CommonResult<>(4444,"异常："+throwable.getMessage(),payment);
    }

    public CommonResult<Payment> blockHandlerFallback(@PathVariable("id") Long id, BlockException blockException){
        Payment payment = new Payment(id, null);
        return new CommonResult<>(5555,"BlockHandler限流处理异常："+blockException.getMessage(),payment);
    }

    @GetMapping("/consumer/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id){
        log.info("使用openFeign进行服务名调用");
        return feignPaymentService.paymentSql(id);
    }
}
