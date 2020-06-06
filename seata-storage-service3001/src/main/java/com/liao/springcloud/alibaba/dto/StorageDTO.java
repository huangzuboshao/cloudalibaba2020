package com.liao.springcloud.alibaba.dto;

import lombok.Data;

/**
 * TODO..
 *
 * @author huangzuboshao
 * @date 2020/6/6 16:28
 */
@Data
public class StorageDTO {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
