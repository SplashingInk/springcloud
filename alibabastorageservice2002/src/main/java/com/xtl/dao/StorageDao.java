package com.xtl.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 31925
 */
@Mapper
public interface StorageDao {

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     */
    void decrease(@Param("productId") Long productId, @Param("count")  Integer count);
}
