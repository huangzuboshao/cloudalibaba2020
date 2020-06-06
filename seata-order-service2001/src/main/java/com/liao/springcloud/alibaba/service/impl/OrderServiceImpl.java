package com.liao.springcloud.alibaba.service.impl;

import com.liao.springcloud.alibaba.constant.OrderStatus;
import com.liao.springcloud.alibaba.util.OrderUtils;
import com.liao.springcloud.alibaba.vo.CommonResultVO;
import com.liao.springcloud.alibaba.dao.OrderMapper;
import com.liao.springcloud.alibaba.dto.OrderDTO;
import com.liao.springcloud.alibaba.entity.Order;
import com.liao.springcloud.alibaba.service.AccountService;
import com.liao.springcloud.alibaba.service.OrderService;
import com.liao.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * TODO..
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:38
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @GlobalTransactional(name = "seata-test", rollbackFor = Exception.class)
    @Override
    public CommonResultVO createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        order.setOrderId(OrderUtils.generateOrderId());
        order.setStatus(OrderStatus.WAIT.getCode());
        log.info("开始创建订单....");
        //创建订单
        orderMapper.insert(order);
        log.info("微服务调用扣库存,做扣减....");
        //扣减库存
        storageService.decrease(orderDTO.getProductId(), orderDTO.getCount());
        //总额
        BigDecimal totalPrice = orderDTO.getUnitPrice().multiply(new BigDecimal(orderDTO.getCount()));
        log.info("微服务调用支付,做支付....");
        //完成支付扣减金额
        accountService.pay(orderDTO.getUserId(), totalPrice);

        //orderMapper.updateOrderStatus(orderDTO.getOrderId(), OrderStatus.FINISHED.getCode());
        orderMapper.updateUserOrderStatus(orderDTO.getUserId(), OrderStatus.FINISHED.getCode());

        return CommonResultVO.success("创建订单成功..");
    }
}
