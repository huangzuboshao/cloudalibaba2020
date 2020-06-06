package com.liao.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.liao.springcloud.alibaba.hanlder.CustomBlockHandler;
import com.liao.springcloud.alibaba.hanlder.CustomFallbackHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO..
 *
 * @author huangzuboshao
 * @date 2020/6/5 17:13
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/by_resource")
    @SentinelResource(value = "byResource", blockHandlerClass = CustomBlockHandler.class, blockHandler = "block_method")
    public String byResource() {
        return "测试按资源名称限流";
    }

    public String fallback_method(BlockException e) {
        return e.getClass().getCanonicalName() + "服务不可用。。。";
    }

    @GetMapping("/test_fallback_block")
    @SentinelResource(value = "fallback", blockHandlerClass = CustomBlockHandler.class, blockHandler = "block_method2",exceptionsToIgnore = {NullPointerException.class}
    ,fallbackClass = CustomFallbackHandler.class,defaultFallback = "defaultFallbackMethod")
    public String byFallbackBlock(@RequestParam(value = "id", required = false) Integer id) {
        if (id == 3) {
            throw new RuntimeException();
        }
        if (id > 3) {
            throw new NullPointerException();
        }
        return "测试blockHandler和fallback";
    }

}
