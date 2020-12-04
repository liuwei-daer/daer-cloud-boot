package com.daer.cloud.system.biz.service.impl;

import com.daer.cloud.system.biz.dto.PermissionTree;
import com.daer.cloud.system.biz.mapper.SysPermissionMapper;
import com.daer.cloud.system.biz.model.SysPermission;
import com.daer.cloud.system.biz.service.ISysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author liuwei
 * @date 2020-11-26
 */
@Slf4j
@Service
public class SysPermissionServiceImpl implements ISysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public Set<String> findPermsByUserId(Integer userId) {
        return sysPermissionMapper.selectPermsByUserId(userId);
    }

    @Override
    public List<SysPermission> findByUserId(Integer userId) {
        return sysPermissionMapper.selectByUserId(userId);
    }

    @Override
    public List<PermissionTree> findMenuByUserId(Integer userId) {
        return sysPermissionMapper.selectMenuByUserId(userId);
    }
}
