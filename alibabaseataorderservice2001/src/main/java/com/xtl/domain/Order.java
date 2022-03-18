package com.xtl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @ClassName Order
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 16:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    /**
    * 订单状态，0：创建中，1：已完成
    * */
    private Integer status;
}
