package com.xtl.controller;

import com.xtl.entity.CommonResult;
import com.xtl.entity.Payment;
import com.xtl.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/4 15:45
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("/payment/create")
    public CommonResult<Object> create(@RequestBody  Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果："+result);
        if(result>0){
            return  new CommonResult<Object>(200,"插入数据库成功,serverPort:"+serverPort,result);
        }else{
            return new CommonResult<Object>(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果："+payment);
        if(payment!=null){
            return  new CommonResult<Payment>(200,"查询数据库成功,serverPort:"+serverPort,payment);
        }else{
            return  new CommonResult<Payment>(404,"查询数据库失败",null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String service:services){
            log.info("主要的服务有："+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info("serviceId:"+instance.getServiceId()+"\t host:"+instance.getHost()+"\t port:"+instance.getPort()+"\t url:"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/openFeignTimeout")
    public String openFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }


    @GetMapping("/payment/zipkin")
    public String getPaymentZipkin(){
        return "welcome to Zipkin,server port:"+serverPort;
    }
}
