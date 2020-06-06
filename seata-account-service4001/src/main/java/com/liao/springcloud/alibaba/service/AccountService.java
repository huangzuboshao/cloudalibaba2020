package com.liao.springcloud.alibaba.service;

import com.liao.springcloud.alibaba.vo.CommonResultVO;

import java.math.BigDecimal;

/**
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:40
 */
public interface AccountService {

    CommonResultVO pay(Long userId, BigDecimal totalPrice);
}
