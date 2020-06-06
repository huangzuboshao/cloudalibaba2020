package com.liao.springcloud.alibaba.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author huangzuboshao
 * @date 2020/6/6 16:22
 */
@Data
@TableName("t_storage")
public class Storage implements Serializable {

    @TableId
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
