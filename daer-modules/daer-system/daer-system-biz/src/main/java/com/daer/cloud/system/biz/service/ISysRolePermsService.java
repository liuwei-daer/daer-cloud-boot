package com.daer.cloud.system.biz.service;


import com.daer.cloud.system.biz.model.SysRolePerms;

import java.util.List;

/**
 * @author liuwei
 * @date 2020-12-07
 */
public interface ISysRolePermsService {

    /**
     * 根据权限code删除角色权限关联信息
     * @return
     */
    void delByPermsCode(final String permsCode);

    /**
     * 插入角色权限关联信息
     * @return
     */
    void insert(SysRolePerms record);

    /**
     * 根据角色ID查询权限列表
     * @return List<String>
     */
    List<String> findPermsCodeByRoleId(final Integer roleId);
}
