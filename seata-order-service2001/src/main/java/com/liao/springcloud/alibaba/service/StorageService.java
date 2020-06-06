package com.liao.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO..
 *
 * @author huangzuboshao
 * @date 2020/6/6 12:39
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    void decrease(@RequestParam("productId") Long productId, @RequestParam("number") Integer number);
}
