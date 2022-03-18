package com.xtl.service.impl;

import com.xtl.dao.StorageDao;
import com.xtl.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName StorageServiceImpl
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 22:47
 */
@Service
@Slf4j
public class StorageServiceImpl  implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("=========开始扣减库存===========");
        storageDao.decrease(productId,count);
        log.info("=========扣减库存结束===========");
    }
}
