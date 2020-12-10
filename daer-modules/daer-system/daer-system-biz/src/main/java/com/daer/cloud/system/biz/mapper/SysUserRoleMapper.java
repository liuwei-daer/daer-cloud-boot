package com.daer.cloud.system.biz.mapper;

import com.daer.cloud.system.biz.model.SysUserRole;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserRoleMapper extends Mapper<SysUserRole> {

    void insertBatch(List<SysUserRole> list);

    void deleteByUserId(@Param("userId") Integer userId);

    void deleteByRoleId(@Param("roleId") Integer roleId);

}