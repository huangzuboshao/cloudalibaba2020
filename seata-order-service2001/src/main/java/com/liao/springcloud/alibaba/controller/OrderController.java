package com.liao.springcloud.alibaba.controller;

import com.liao.springcloud.alibaba.dto.OrderDTO;
import com.liao.springcloud.alibaba.vo.CommonResultVO;
import com.liao.springcloud.alibaba.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:25
 */
@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @PutMapping("/create")
    public CommonResultVO createOrder(OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }
}
