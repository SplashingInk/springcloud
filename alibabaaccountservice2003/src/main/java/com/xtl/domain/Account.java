package com.xtl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @ClassName Account
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 23:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
    private Long id;
    private Long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;
}
