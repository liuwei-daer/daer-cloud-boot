package com.daer.cloud.system.biz.mapper;

import com.daer.cloud.system.biz.model.SysRolePerms;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysRolePermsMapper extends Mapper<SysRolePerms> {

    int delByPermsCode(@Param("permsCode") String PermsCode);

    int delByRoleId(@Param("roleId") Integer roleId);

    List<String> selectPermsCodeByRoleId(@Param("roleId") Integer roleId);

    void insertBatch(List<SysRolePerms> list);

}