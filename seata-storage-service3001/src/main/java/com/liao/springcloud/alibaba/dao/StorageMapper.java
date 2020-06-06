package com.liao.springcloud.alibaba.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liao.springcloud.alibaba.entity.Storage;
import org.apache.ibatis.annotations.Param;

/**
 * @author huangzuboshao
 * @date 2020/6/6 16:23
 */
public interface StorageMapper extends BaseMapper<Storage> {
    int decreaseStorage(@Param("productId") Long productId, @Param("count") Integer number);
}
