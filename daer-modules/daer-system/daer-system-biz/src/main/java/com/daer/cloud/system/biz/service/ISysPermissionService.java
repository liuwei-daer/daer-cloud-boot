package com.daer.cloud.system.biz.service;

import com.daer.cloud.system.biz.dto.PermissionDTO;
import com.daer.cloud.system.biz.model.SysUser;
import com.daer.cloud.system.biz.vo.PermissionTree;
import com.daer.cloud.system.biz.model.SysPermission;
import com.daer.cloud.system.biz.vo.PermsSelTree;

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
     * @return List<SysPermission>
     */
    List<SysPermission> findByUserId(Integer userId);

    /**
     * 根据用户ID查询用户菜单
     * @param userId 用户Id
     * @return List<PermissionTree>
     */
    List<PermissionTree> findMenuByUserId(Integer userId);

    /**
     * 根据用户查询用户权限树
     * @param permissionDTO 用户Id
     * @return List<PermissionTree>
     */
    List<PermissionTree> findTreeByUser(PermissionDTO permissionDTO);


    /**
     * 根据用户查询用户权限下拉树
     * @param user 用户
     * @return List<PermsSelTree>
     */
    List<PermsSelTree> findSelTreeByUser(SysUser user);
}
