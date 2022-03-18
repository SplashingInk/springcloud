package com.xtl.service;

import com.xtl.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 31925
 */
public interface PaymentService {
    /**
     *添加订单
     * @param payment 支付订单
     * @return 影响的行数
     */
    int create(Payment payment);

    /**
     * 根据id查询订单
     * @param id 订单id
     * @return 返回订单
     */
    Payment getPaymentById(@Param("id") Long id);
}
