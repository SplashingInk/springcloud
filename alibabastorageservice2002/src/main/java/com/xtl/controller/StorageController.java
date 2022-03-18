package com.xtl.controller;

import com.xtl.domain.CommonResult;
import com.xtl.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName StorageController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 22:53
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId,count);
        return new CommonResult<>(200,"扣减库存成功");
    }
}
