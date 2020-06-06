package com.liao.springcloud.alibaba.hanlder;

/**
 * fallback 回退
 *
 * @author huangzuboshao
 * @date 2020/6/5 18:00
 */
public class CustomFallbackHandler {

    public static String fallbackMethod(Throwable e) {
        return "Fallback1";
    }

    public static String fallbackMethod2(Integer id,Throwable e) {
        return "Fallback2";
    }

    public static String defaultFallbackMethod(){
        return "defaultfallback";
    }
}
