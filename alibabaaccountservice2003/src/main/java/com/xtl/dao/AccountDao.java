package com.xtl.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author 31925
 */
@Mapper
public interface AccountDao {

    /**
     * 扣减金额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(@Param("userId") Long userId,@Param("money")  BigDecimal money);
}
