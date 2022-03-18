package com.xtl.service;

import com.xtl.domain.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @author 31925
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order 订单
     */
    void create(Order order);

    /**
     * 更新订单状态
     * @param userId 用户id
     * @param status 订单状态
     */
    void update(Long userId,Integer status);
}
