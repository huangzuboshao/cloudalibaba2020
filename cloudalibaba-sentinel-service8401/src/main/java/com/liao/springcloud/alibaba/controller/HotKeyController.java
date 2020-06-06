package com.liao.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 热点
 *
 * @author huangzuboshao
 * @date 2020/6/5 16:42
 */
@RestController
@Slf4j
public class HotKeyController {

    @GetMapping("/test/hot")
    @SentinelResource(value = "hot", blockHandler = "fallback_method")
    public String hot(@RequestParam(value = "p1", required = false) String p1,
                      @RequestParam(value = "p2", required = false) String p2) {
        log.info("测试热点规则");
        return "测试热点规则";
    }

    public String fallback_method( String param0,String param1, BlockException e) {
        return "自定义热点sentinel降级";
    }
}
