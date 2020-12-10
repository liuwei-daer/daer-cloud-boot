package com.daer.cloud.system.biz.mapper;

import com.daer.cloud.system.biz.model.SysUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserMapper extends Mapper<SysUser> {

    SysUser selectByUsername(@Param("username") String username);

    List<SysUser> selectBySearch(@Param("username") String username,@Param("status") String status,@Param("deptList") List<Integer> deptList);

    int selectUserIsExists(@Param("username") String username,@Param("id") Integer id);

}