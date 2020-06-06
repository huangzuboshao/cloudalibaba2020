package com.liao.springcloud.alibaba.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author huangzuboshao
 * @date 2020/6/6 15:37
 */
public class OrderUtils {

    /**
     * 订单编号前缀
     */
    public static final String PREFIX = "DD";
    /**
     * 订单编号后缀（核心部分）
     */
    private static long code;

    /**
     * 生成订单号
     */
    public static synchronized String generateOrderId() {
        code++;
        String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        long m = Long.parseLong((str)) * 10000;
        m += code;
        return PREFIX + m;
    }
}
