package com.daer.cloud.system.biz.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuwei
 * @date 2020-12-07
 */
@Data
public class RoleGrantFunDTO implements Serializable {

    private Integer roleId;

    private List<String> permsCodeList;
}

