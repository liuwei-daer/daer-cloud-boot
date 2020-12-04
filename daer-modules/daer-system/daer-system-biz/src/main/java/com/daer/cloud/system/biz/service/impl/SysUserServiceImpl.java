package com.daer.cloud.system.biz.service.impl;

import com.daer.cloud.system.biz.mapper.SysUserMapper;
import com.daer.cloud.system.biz.service.ISysPermissionService;
import com.daer.cloud.system.biz.service.ISysRoleService;
import com.daer.cloud.system.biz.service.ISysUserService;
import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.biz.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@Slf4j
@Service
public class SysUserServiceImpl implements ISysUserService {

	private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private ISysRoleService sysRoleService;

	@Autowired
	private ISysPermissionService sysPermissionService;

	/**
	 * 通过查用户的全部信息
	 *
	 * @param sysUser 用户
	 * @return
	 */
	@Override
	public UserInfo getUserInfo(SysUser sysUser) {
		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(sysUser,userInfo);
		userInfo.setUserId(sysUser.getId());
		userInfo.setUsername(sysUser.getUserName());
		//设置角色列表  （ID）
		List<Integer> roleIds = sysRoleService.findRoleIdByUserId(sysUser.getId());
		userInfo.setRoles(roleIds);
		//设置权限列表（permission）
		Set<String> permissions = sysPermissionService.findPermsByUserId(sysUser.getId());
		userInfo.setPermissions(permissions);
		return userInfo;
	}

	@Override
	public SysUser findByusername(String username) {
		return sysUserMapper.selectByUsername(username);
	}

	@Override
	public SysUser findById(Integer userId) {
		return sysUserMapper.selectByPrimaryKey(userId);
	}
}
