package com.liao.springcloud.alibaba.controller;

import com.liao.springcloud.alibaba.service.StorageService;
import com.liao.springcloud.alibaba.vo.CommonResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO..
 *
 * @author huangzuboshao
 * @date 2020/6/6 16:20
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @PostMapping("/decrease")
    public CommonResultVO decreaseStorage(@RequestParam("productId") Long productId,
                                          @RequestParam("number") Integer number) {
        return storageService.decreaseStorage(productId,number);
    }
}
