package com.daer.cloud.system.biz.dto;

import lombok.Data;

/**
 * @author liuwei
 * @date 2020-12-10
 */
@Data
public class PermissionDTO {

    private Integer userId;

    private String userName;

    private String permsName;

    private String permsKey;

    private String visible;

}
