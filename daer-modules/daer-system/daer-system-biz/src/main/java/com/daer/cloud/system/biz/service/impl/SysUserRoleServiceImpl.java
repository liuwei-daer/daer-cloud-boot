package com.daer.cloud.system.biz.service.impl;

import com.daer.cloud.system.biz.mapper.SysUserRoleMapper;
import com.daer.cloud.system.biz.model.SysUserRole;
import com.daer.cloud.system.biz.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwei
 * @date 2020-12-09
 */
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    @Override
    public void insertBatch(List<SysUserRole> list){
        sysUserRoleMapper.insertBatch(list);
    }

    @Override
    public void insertBatch(List<Integer> roles, Integer userId) {
        insertBatch(getSysUserRoleList(roles,userId));
    }

    @Override
    public void deleteByUserId(Integer userId){
        sysUserRoleMapper.deleteByUserId(userId);
    }

    /**
     * 获取系统用户角色列表
     * @param roles
     * @param userId
     * return
     * */
    private List<SysUserRole> getSysUserRoleList(List<Integer> roles, Integer userId){
        List<SysUserRole> list = new ArrayList<>();
        for (Integer integer : roles) {
            SysUserRole userRole = new SysUserRole();
            userRole.setRoleId(integer);
            userRole.setUserId(userId);
            list.add(userRole);
        }
        return list;
    }

}
