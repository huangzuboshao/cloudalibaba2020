package com.liao.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 降级
 *
 * @author huangzuboshao
 * @date 2020/6/5 16:05
 */
@RestController
@Slf4j
public class FallbackController {

    @GetMapping("/test/RT")
    public String getRT() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("测试RT");
        return "testRT";
    }

    @GetMapping("/test/abnormal_proportion")
    public String getD() {
        log.info("测试异常比例");
        int a = 10 / 0;
        return "测试异常比例";
    }

    @GetMapping("/test/degrade_exception_count")
    public String getE() {
        log.info("测试异常比例");
        int a = 10 / 0;
        return "测试异常数";
    }
}
