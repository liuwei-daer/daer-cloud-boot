package com.daer.cloud.system.biz.service.impl;

import com.daer.cloud.system.biz.mapper.SysRoleMapper;
import com.daer.cloud.system.biz.model.SysRole;
import com.daer.cloud.system.biz.service.ISysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuwei
 * @date 2020-11-26
 */
@Slf4j
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findByUserId(Integer userId) {
        return sysRoleMapper.selectByUserId(userId);
    }

    @Override
    public List<Integer> findRoleIdByUserId(Integer userId) {
        return sysRoleMapper.selectRoleIdByUserId(userId);
    }
}
