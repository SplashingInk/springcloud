package com.xtl.service.impl;

import com.xtl.dao.PaymentDao;
import com.xtl.entity.Payment;
import com.xtl.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PaymentServiceImpl
 * @Description TODO
 * @Author xtl
 * @Date 2022/3/4 15:43
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
       return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return  paymentDao.getPaymentById(id);
    }
}
