package com.daer.cloud.system.biz.model;

import javax.persistence.*;

@Table(name = "sys_role_perms")
public class SysRolePerms {
    /**
     * 角色ID
     */
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限CODE
     */
    @Id
    @Column(name = "perms_code")
    private String permsCode;

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取权限CODE
     *
     * @return perms_code - 权限CODE
     */
    public String getPermsCode() {
        return permsCode;
    }

    /**
     * 设置权限CODE
     *
     * @param permsCode 权限CODE
     */
    public void setPermsCode(String permsCode) {
        this.permsCode = permsCode == null ? null : permsCode.trim();
    }
}