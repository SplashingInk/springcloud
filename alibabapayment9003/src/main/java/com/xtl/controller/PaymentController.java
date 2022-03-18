package com.xtl.controller;

import com.xtl.entity.CommonResult;
import com.xtl.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @ClassName PaymentController
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 1:24
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    public static HashMap<Long, Payment> map=new HashMap<>(16);

    static {
        map.put(1L,new Payment(1L,"JOKER"));
        map.put(2L,new Payment(2L,"KING"));
        map.put(3L,new Payment(3L,"QUEEN"));
    }

    @GetMapping("/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id){
        Payment payment = map.get(id);
        return new CommonResult<>(200,"server port:"+serverPort,payment);
    }


}
