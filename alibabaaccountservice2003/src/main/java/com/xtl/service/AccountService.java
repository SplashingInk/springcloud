package com.xtl.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author 31925
 */
public interface AccountService {
    /**
     * 扣减金额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);
}
