package com.daer.cloud.system.biz.mapper;

import com.daer.cloud.system.biz.model.SysDept;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysDeptMapper extends Mapper<SysDept> {

    List<Integer> selectChildrenById(@Param("id") Integer id);
}