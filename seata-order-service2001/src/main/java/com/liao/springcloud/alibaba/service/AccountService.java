package com.liao.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:40
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping("/accounts/pay")
    void pay(@RequestParam("userId") Long userId, @RequestParam("totalPrice")BigDecimal totalPrice);
}
