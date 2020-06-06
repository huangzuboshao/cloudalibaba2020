package com.liao.springcloud.alibaba.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.liao.springcloud.alibaba.dao.AccountMapper;
import com.liao.springcloud.alibaba.entity.Account;
import com.liao.springcloud.alibaba.service.AccountService;
import com.liao.springcloud.alibaba.vo.CommonResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * TODO..
 *
 * @author huangzuboshao
 * @date 2020/6/6 17:00
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public CommonResultVO pay(Long userId, BigDecimal totalPrice) {
        //判断当前用户是否有足够的钱
        LambdaQueryWrapper<Account> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(Account::getUserId, userId);
        Account resultAccount = accountMapper.selectOne(queryWrapper);
        if (resultAccount.getResidue().subtract(totalPrice).compareTo(BigDecimal.ZERO) < 0) {
            throw new NullPointerException();
        }
        int result = accountMapper.pay(userId, totalPrice);
        return CommonResultVO.success("支付成功.." + totalPrice);
    }
}
