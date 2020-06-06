package com.liao.springcloud.alibaba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liao.springcloud.alibaba.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * TODO..
 *
 * @author huangzuboshao
 * @date 2020/6/6 16:55
 */
public interface AccountMapper extends BaseMapper<Account> {
    /**
     * 支付
     * @param userId
     * @param totalPrice
     * @return
     */
    int pay(@Param("userId") Long userId, @Param("price") BigDecimal totalPrice);
}
