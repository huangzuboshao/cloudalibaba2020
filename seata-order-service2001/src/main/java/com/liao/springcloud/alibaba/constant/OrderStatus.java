package com.liao.springcloud.alibaba.constant;

import lombok.Getter;

/**
 *
 * @author huangzuboshao
 * @date 2020/6/6 16:08
 */
@Getter
public enum OrderStatus {
    /**
     * 待支付
     */
    WAIT(0),
    /**
     * 已支付
     */
    FINISHED(1);

    private Integer code;

    OrderStatus(Integer code) {
        this.code = code;
    }
}
