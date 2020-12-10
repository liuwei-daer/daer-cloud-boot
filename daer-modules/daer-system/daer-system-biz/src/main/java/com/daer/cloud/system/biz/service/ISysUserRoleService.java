package com.daer.cloud.system.biz.service;

import com.daer.cloud.system.biz.model.SysUserRole;

import java.util.List;

/**
 * @author liuwei
 * @date 2020-12-09
 */
public interface ISysUserRoleService {

    /**
     * 批量插入用户角色绑定
     * @param list
     * @return
     */
    void insertBatch(List<SysUserRole> list);

    /**
     * 批量插入用户角色绑定
     * @param roles
     * @param userId
     * @return
     */
    void insertBatch(List<Integer> roles, Integer userId);

    /**
     * 根据用户ID删除用户角色绑定
     * @param userId 用户Id
     * @return
     */
    void deleteByUserId(Integer userId);

}
