package com.liao.springcloud.alibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 *
 * @author huangzuboshao
 * @date 2020/6/6 10:35
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.liao.springcloud.alibaba.dao")
public class StorageMain3001 {
    public static void main(String[] args) {
        SpringApplication.run(StorageMain3001.class, args);
    }
}
