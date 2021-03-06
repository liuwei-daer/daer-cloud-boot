package com.daer.cloud.system.biz.service;


import com.daer.cloud.system.biz.dto.SysRoleDTO;
import com.daer.cloud.system.biz.model.SysRole;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuwei
 * @date 2019-11-24
 */
public interface ISysRoleService {

    /**
     * 根据用户ID查询用户角色列表
     * @param userId 用户Id
     * @return List<SysRole>
     */
    List<SysRole> findByUserId(@Param("userId") Integer userId);

    /**
     * 根据用户ID查询用户角色ID列表
     * @param userId 用户Id
     * @return List<Integer>
     */
    List<Integer> findRoleIdByUserId(@Param("userId") Integer userId);

    /**
     * 查询所有角色列表
     * @return List<SysRole>
     */
    List<SysRole> findByAll();

    /**
     * 分页查询角色列表
     * @return List<SysRole>
     */
    PageInfo<SysRole> findByPage(SysRoleDTO sysRoleDTO);

}
