package com.xtl.service;

import com.xtl.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author 31925
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    /**
     * 扣减金额
     * @param userId 用户id
     * @param money 金额
     * @return  扣减金额
     */
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
