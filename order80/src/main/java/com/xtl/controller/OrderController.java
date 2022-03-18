package com.xtl.controller;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import com.xtl.entity.CommonResult;
import com.xtl.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/4 16:36
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Payment> requestEntity = new HttpEntity<Payment>(payment, requestHeaders);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",requestEntity,CommonResult.class);
    }

    @PostMapping("/consumer/payment/create2")
    public CommonResult<Payment> create2(@RequestBody Payment payment){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Payment> requestEntity = new HttpEntity<Payment>(payment, requestHeaders);
        ResponseEntity<CommonResult> commonResultResponseEntity = restTemplate.postForEntity(PAYMENT_URL + "/payment/create", requestEntity, CommonResult.class);
        if(commonResultResponseEntity.getStatusCode().is2xxSuccessful()){
            CommonResult result=commonResultResponseEntity.getBody();
            log.info("插入数据的详细信息是： "+result);
            return result;
        }else {
            return new CommonResult<Payment>(503,"插入数据库失败");
        }
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class,id);
        if(entity.getStatusCode().is2xxSuccessful()){
            CommonResult<Payment> result = entity.getBody();
            log.info("查询到数据的详细信息是："+result);
            return result;
        }else{
            return new CommonResult<Payment>(444,"查询数据库失败");
        }
    }

    @GetMapping("/consumer/payment/zipkin")
    public String getPaymentZipkin(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zipkin",String.class);
    }
}
