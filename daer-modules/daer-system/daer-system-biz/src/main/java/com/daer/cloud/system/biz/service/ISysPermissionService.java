package com.daer.cloud.system.biz.service;

import com.daer.cloud.system.biz.dto.PermissionTree;
import com.daer.cloud.system.biz.model.SysPermission;

import java.util.List;
import java.util.Set;

/**
 * @author liuwei
 * @date 2020-11-26
 */
public interface ISysPermissionService {

    /**
     * 根据用户ID查询用户权限标识列表
     * @param userId 用户Id
     * @return List<String>
     */
    Set<String> findPermsByUserId(Integer userId);

    /**
     * 根据用户ID查询用户权限
     * @param userId 用户Id
     * @return List<String>
     */
    List<SysPermission> findByUserId(Integer userId);

    List<PermissionTree> findMenuByUserId(Integer userId);
}
