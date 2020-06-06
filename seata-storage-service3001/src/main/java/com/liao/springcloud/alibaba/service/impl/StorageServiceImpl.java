package com.liao.springcloud.alibaba.service.impl;

import com.liao.springcloud.alibaba.dao.StorageMapper;
import com.liao.springcloud.alibaba.entity.Storage;
import com.liao.springcloud.alibaba.service.StorageService;
import com.liao.springcloud.alibaba.vo.CommonResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangzuboshao
 * @date 2020/6/6 16:21
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageMapper storageMapper;

    @Override
    public CommonResultVO decreaseStorage(Long productId, Integer number) {
        //查该商品库存量
        Map<String, Object> paramMap = new HashMap<>(3);
        paramMap.put("product_id", productId);
        List<Storage> storageList = storageMapper.selectByMap(paramMap);
        if (CollectionUtils.isEmpty(storageList)) {
            throw new NullPointerException();
        }
        //现有存量
        Integer residue = storageList.get(0).getResidue();
        if (number > residue) {
            //超卖
            throw new NullPointerException();
        } else {
            int rows = storageMapper.decreaseStorage(productId, number);
            return CommonResultVO.success("影响行数:" + rows);
        }
    }
}
