package com.daer.cloud.system.biz.mapper;

import com.daer.cloud.system.biz.vo.PermissionTree;
import com.daer.cloud.system.biz.model.SysPermission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Set;

public interface SysPermissionMapper extends Mapper<SysPermission> {

    Set<String> selectPermsByUserId(@Param("userId") Integer userId);

    List<SysPermission> selectByUserId(@Param("userId") Integer userId);

    List<PermissionTree> selectMenuByUserId(@Param("userId") Integer userId);

}