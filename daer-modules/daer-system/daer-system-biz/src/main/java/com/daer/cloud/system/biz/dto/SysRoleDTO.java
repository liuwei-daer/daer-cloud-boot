package com.daer.cloud.system.biz.dto;

import com.daer.cloud.common.core.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Created by liuwei
 * date 2017-04-11
 */
@Data
public class SysRoleDTO extends BaseEntity {

    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色权限字符串
     */
    private String roleKey;

    /**
     * 角色状态（0正常 1停用）
     */
    private String status;

    /**
     * 备注
     */
    private String remark;


}
