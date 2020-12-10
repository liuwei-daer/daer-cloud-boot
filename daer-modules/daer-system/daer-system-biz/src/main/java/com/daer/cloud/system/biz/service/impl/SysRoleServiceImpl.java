package com.daer.cloud.system.biz.service.impl;

import com.daer.cloud.common.core.constant.CommonConstants;
import com.daer.cloud.system.biz.dto.SysRoleDTO;
import com.daer.cloud.system.biz.mapper.SysRoleMapper;
import com.daer.cloud.system.biz.model.SysRole;
import com.daer.cloud.system.biz.model.SysUser;
import com.daer.cloud.system.biz.service.ISysRoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public List<SysRole> findByAll() {
        SysRole sysRole = new SysRole();
        sysRole.setDelFlag(CommonConstants.STATUS_NORMAL);
        return sysRoleMapper.select(sysRole);
    }

    @Override
    public PageInfo<SysRole> findByPage(SysRoleDTO sysRoleDTO) {
        if (!StringUtils.isEmpty(sysRoleDTO.getPageNum()) && !StringUtils.isEmpty(sysRoleDTO.getPageSize())) {
            PageHelper.startPage(sysRoleDTO.getPageNum(), sysRoleDTO.getPageSize());
        }
        List<SysRole> list = sysRoleMapper.selectBySearch(sysRoleDTO);
        PageInfo<SysRole> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
