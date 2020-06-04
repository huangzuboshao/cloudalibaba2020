package com.liao.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * TODO..
 *
 * @author huangzuboshao
 * @date 2020/6/4 19:08
 */
@RestController
@Slf4j
@RefreshScope
public class OrderController {

    private static final String SRV = "http://nacos-provider-service";

    @Value("${config.version}")
    private String version;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/orders/{id}")
    public String test(@PathVariable("id") Integer id) {
        log.info("当前version 【{}】",version);
        return restTemplate.getForObject(SRV + "/payment/nacos/" + id, String.class);
    }
}
