package com.liao.springcloud.alibaba.service;

import com.liao.springcloud.alibaba.dto.OrderDTO;
import com.liao.springcloud.alibaba.vo.CommonResultVO;

/**
 * 订单服务
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:28
 */
public interface OrderService {
    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    CommonResultVO createOrder(OrderDTO orderDTO);
}
