package com.liao.springcloud.alibaba.service;

import com.liao.springcloud.alibaba.vo.CommonResultVO;

/**
 *
 * @author huangzuboshao
 * @date 2020/6/6 16:21
 */
public interface StorageService {
    CommonResultVO decreaseStorage(Long productId, Integer number);
}
