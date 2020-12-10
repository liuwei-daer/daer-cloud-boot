package com.daer.cloud.system.biz.service.impl;

import com.daer.cloud.system.biz.mapper.SysRolePermsMapper;
import com.daer.cloud.system.biz.model.SysRolePerms;
import com.daer.cloud.system.biz.service.ISysRolePermsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author liuwei
 * @date 2020-12-07
 */
@Slf4j
@Service
public class SysRolePermsServiceImpl implements ISysRolePermsService {

    @Autowired
    SysRolePermsMapper sysRolePermsMapper;

    @Override
    public void delByPermsCode(String permsCode) {
        sysRolePermsMapper.delByPermsCode(permsCode);
    }

    @Override
    public void insert(SysRolePerms record) {
        sysRolePermsMapper.insert(record);
    }

    @Override
    public List<String> findPermsCodeByRoleId(Integer roleId) {
        return sysRolePermsMapper.selectPermsCodeByRoleId(roleId);
    }
}
