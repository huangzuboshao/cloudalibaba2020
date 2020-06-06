package com.liao.springcloud.alibaba.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * account实体
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:29
 */
@Data
@TableName("t_account")
public class Account implements Serializable {

    @TableId
    private String id;

    private Long userId;

    private BigDecimal total;

    private BigDecimal used;

    private BigDecimal residue;
}
