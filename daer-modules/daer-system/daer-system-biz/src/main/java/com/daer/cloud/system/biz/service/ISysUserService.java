package com.daer.cloud.system.biz.service;

import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.biz.model.SysUser;

/**
 * @author liuwei
 * @date 2019-11-24
 */
public interface ISysUserService {

	/**
	 * 查询用户信息
	 * @param sysUser 用户
	 * @return userInfo
	 */
	UserInfo getUserInfo(SysUser sysUser);

	/**
	 * 根据用户名查询用户信息
	 * @param username 用户
	 * @return SysUser
	 */
	SysUser findByusername(String username);

	/**
	 * 根据用户ID查询用户信息
	 * @param userId 用户ID
	 * @return SysUser
	 */
	SysUser findById(Integer userId);
}
