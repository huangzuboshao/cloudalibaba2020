package com.liao.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author huangzuboshao
 * @date 2020/6/4 18:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain9001.class, args);
    }
}
