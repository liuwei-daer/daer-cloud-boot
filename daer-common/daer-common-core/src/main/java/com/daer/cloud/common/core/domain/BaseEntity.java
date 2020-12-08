package com.daer.cloud.common.core.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Entity基类
 *
 * @author liuwei
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 搜索值
     */
    private String searchValue;

    /**
     * 当前页
     */
    private Integer pageNum = 1;

    /**
     * 每页多少条
     */
    private Integer pageSize = 10;

}
