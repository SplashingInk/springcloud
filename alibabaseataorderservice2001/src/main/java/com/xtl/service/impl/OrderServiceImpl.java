package com.xtl.service.impl;

import com.xtl.dao.OrderDao;
import com.xtl.domain.Order;
import com.xtl.service.AccountService;
import com.xtl.service.OrderService;
import com.xtl.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/7 17:04
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name="create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("=========开始创建订单========");
        orderDao.create(order);
        log.info("=========开始调用扣减库存的微服务========");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("=========开始调用扣减账户金额的微服务========");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("=========开始修改订单状态========");
        orderDao.update(order.getUserId(),0);
        log.info("=========成功修改订单状态========");
        log.info("=========创建订单完成========");
    }

    @Override
    public void update(Long userId, Integer status) {

    }
}
