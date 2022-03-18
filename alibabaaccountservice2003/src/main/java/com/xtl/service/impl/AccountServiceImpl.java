package com.xtl.service.impl;

import com.xtl.dao.AccountDao;
import com.xtl.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName AccountServiceImpl
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 23:13
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("=========开始扣减账户金额============");
        // try {
        //     TimeUnit.SECONDS.sleep(10);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        accountDao.decrease(userId,money);
        log.info("=========扣减账户金额结束============");
    }
}
