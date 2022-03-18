package com.xtl.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName HystrixServiceFallback
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/5 17:41
 */
@Component
public class HystrixServiceFallbackImpl implements HystrixService{
    @Override
    public String hystrixOk(Integer id) {
        return "hystrixOk响应出错";
    }

    @Override
    public String hystrixTimeout(Integer id) {
        return  "hystrixTimeout响应出错";
    }
}
