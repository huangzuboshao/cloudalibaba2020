package com.liao.springcloud.alibaba.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:36
 */
@Data
public class AccountDTO {

    private String id;

    private Long userId;

    private BigDecimal total;

    private BigDecimal used;

    private BigDecimal residue;

}
