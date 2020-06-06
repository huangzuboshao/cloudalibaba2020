package com.liao.springcloud.alibaba.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Order实体
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:29
 */
@Data
@TableName("t_order")
public class Order implements Serializable {

    @TableId("id")
    private String orderId;

    @TableField("user_id")
    private Long userId;

    @TableField("product_id")
    private Long productId;

    private Integer count;

    @TableField("unit_price")
    private BigDecimal unitPrice;

    @TableField(value="status")
    private Integer status;
}
