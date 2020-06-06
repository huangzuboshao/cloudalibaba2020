package com.liao.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * TODO..
 *
 * @author huangzuboshao
 * @date 2020/6/4 23:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8401 {
    public static void main(String[] args){
        SpringApplication.run(SentinelMain8401.class,args);
    }
}
