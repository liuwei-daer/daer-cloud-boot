package com.daer.cloud.system.biz.service;

import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.biz.dto.ChangePasswordDTO;
import com.daer.cloud.system.biz.model.SysUser;
import com.daer.cloud.system.biz.dto.SysUserDTO;
import com.github.pagehelper.PageInfo;

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

	/**
	 * 分页查询用户列表
	 * @param sysUserDTO
	 * @return PageInfo<SysUser>
	 */
	PageInfo<SysUser> findByPage(SysUserDTO sysUserDTO);

	/**
	 * 根据用户ID查询用户信息
	 * @param userId 用户ID
	 * @return SysUser
	 */
	UserInfo findById(Integer userId);

	/**
	 * 保存用户信息
	 * @param sysUserDTO
	 * @return success/fail
	 */
	void addUser(SysUserDTO sysUserDTO);

	/**
	 * 保存用户信息
	 * @param sysUserDTO
	 * @return success/fail
	 */
	void editUser(SysUserDTO sysUserDTO);

	void changeStatus(SysUserDTO sysUserDTO);

	/**
	 * 删除用户信息
	 * @param userId
	 * @return success/fail
	 */
	void deleteById(Integer userId);

	/**
	 * 重置用户密码
	 * @param changePasswordDTO
	 * @return success/fail
	 */
	void resetPwd(ChangePasswordDTO changePasswordDTO);

}
