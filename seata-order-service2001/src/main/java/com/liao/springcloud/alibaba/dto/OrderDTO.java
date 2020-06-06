package com.liao.springcloud.alibaba.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * TODO..
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:36
 */
@Data
public class OrderDTO {
    private String orderId;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal unitPrice;

    private Integer status;
}
