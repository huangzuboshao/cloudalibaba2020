package com.liao.springcloud.alibaba.config;

import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * TODO..
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:25
 */
@Configuration
@MapperScan("com.liao.springcloud.alibaba.dao")
public class MybatisPlusConfiguration {
    @Bean
    @Profile({"dev"})
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(5 * 1000L);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
}
