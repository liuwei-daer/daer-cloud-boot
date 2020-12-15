package com.daer.cloud.system.biz.vo;

import lombok.Data;

import java.util.List;

/**
 * @author liuwei
 * @date 2020-12-15
 */
@Data
public class PermsSelTree {

    private String key;

    private String parentId;

    private String value;

    private String title;

    private List<PermsSelTree> children;
}
