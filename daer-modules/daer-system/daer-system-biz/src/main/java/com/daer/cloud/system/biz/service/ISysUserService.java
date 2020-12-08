package com.daer.cloud.system.biz.service;

import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.biz.model.SysUser;
import com.daer.cloud.system.biz.vo.SysUserVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
	SysUser findByUsername(String username);

	PageInfo<SysUser> findByPage(SysUserVO sysUserVO);

	/**
	 * 根据用户ID查询用户信息
	 * @param userId 用户ID
	 * @return SysUser
	 */
	UserInfo findById(Integer userId);

}
