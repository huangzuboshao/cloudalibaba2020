package com.liao.springcloud.alibaba.controller;

import com.liao.springcloud.alibaba.service.AccountService;
import com.liao.springcloud.alibaba.vo.CommonResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 支付
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:25
 */
@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/pay")
    public CommonResultVO pay(@RequestParam("userId") Long userId, @RequestParam("totalPrice")BigDecimal totalPrice) {
        return accountService.pay(userId, totalPrice);
    }
}
