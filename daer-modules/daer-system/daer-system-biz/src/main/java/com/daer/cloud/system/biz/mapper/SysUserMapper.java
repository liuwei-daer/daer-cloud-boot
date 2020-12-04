package com.daer.cloud.system.biz.mapper;

import com.daer.cloud.system.biz.model.SysUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper extends Mapper<SysUser> {

    SysUser selectByUsername(@Param("username") String username);

}