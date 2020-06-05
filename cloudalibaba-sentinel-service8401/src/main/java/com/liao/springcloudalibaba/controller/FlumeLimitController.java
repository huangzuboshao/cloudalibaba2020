package com.liao.springcloudalibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流控
 *
 * @author huangzuboshao
 * @date 2020/6/5 10:25
 */
@RestController
public class FlumeLimitController {

    @GetMapping("/testA")
    public String getA() {
        return "testA";
    }


    @GetMapping("/testB")
    public String getB() {
        return "testB";
    }
}
