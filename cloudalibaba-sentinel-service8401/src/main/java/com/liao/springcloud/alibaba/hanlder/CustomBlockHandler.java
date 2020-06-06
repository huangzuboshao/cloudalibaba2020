package com.liao.springcloud.alibaba.hanlder;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 自定义降级
 *
 * @author huangzuboshao
 * @date 2020/6/5 17:25
 */
public class CustomBlockHandler {

    public static String block_method(BlockException e) {
        return "sentinel Block";
    }

    public static String block_method2(Integer id,BlockException e) {
        return "sentinel Block2";
    }
}
