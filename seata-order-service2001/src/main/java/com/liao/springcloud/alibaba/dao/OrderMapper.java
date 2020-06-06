package com.liao.springcloud.alibaba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liao.springcloud.alibaba.entity.Order;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:44
 */
public interface OrderMapper extends BaseMapper<Order> {

    /**
     * 修改订单状态
     * @param orderId 订单号
     * @param status 订单状态
     */
    void updateOrderStatus(@Param("orderId") String orderId, @Param("status") Integer status);

    void updateUserOrderStatus(@Param("userId") Long userId, @Param("status") Integer status);
}
