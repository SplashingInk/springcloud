package com.xtl.controller;

import com.xtl.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ProviderController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/6 14:10
 */
@RestController
public class ProviderController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return messageProvider.send();
    }

}
