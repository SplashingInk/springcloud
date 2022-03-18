package com.xtl.controller;

import com.xtl.domain.CommonResult;
import com.xtl.domain.Order;
import com.xtl.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 17:20
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"成功创建订单");
    }
}
