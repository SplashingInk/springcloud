package com.xtl.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName FlowLimitController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/6 22:49
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "------testB";
    }

    @GetMapping("/testC")
    public String testC(){
        log.info(Thread.currentThread().getName()+"\t 处理请求");
        return "------testC";
    }

    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("测试RT");
        return "------testD，测试RT";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "hotKey",required = false) String hotKey,
                             @RequestParam(value = "coldKey",required = false) String coldKey){
        log.info("测试testHostKey");
        return "------测试testHostKey";
    }

    public String dealTestHotKey(String hotKey, String coldKey, BlockException exception){
        log.info("这是热点key的降级处理方法");
        return "这是热点key的降级处理方法";
    }

}
