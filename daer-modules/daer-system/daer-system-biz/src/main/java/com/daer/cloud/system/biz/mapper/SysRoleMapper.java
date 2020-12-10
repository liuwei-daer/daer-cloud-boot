package com.daer.cloud.system.biz.mapper;

import com.daer.cloud.system.biz.dto.SysRoleDTO;
import com.daer.cloud.system.biz.model.SysRole;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysRoleMapper extends Mapper<SysRole> {

    List<SysRole> selectByUserId(@Param("userId") Integer userId);


    List<Integer> selectRoleIdByUserId(@Param("userId") Integer userId);

    List<SysRole> selectBySearch(@Param("sysRoleDTO")SysRoleDTO sysRoleDTO);

}