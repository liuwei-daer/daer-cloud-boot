package com.daer.cloud.system.biz.service.impl;

import com.daer.cloud.common.core.constant.CommonConstants;
import com.daer.cloud.common.core.exception.BizException;
import com.daer.cloud.system.biz.dto.ChangePasswordDTO;
import com.daer.cloud.system.biz.mapper.SysUserMapper;
import com.daer.cloud.system.biz.service.*;
import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.biz.model.SysUser;
import com.daer.cloud.system.biz.dto.SysUserDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author liuwei
 * @date 2020-12-07
 */
@Slf4j
@Service
public class SysUserServiceImpl implements ISysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private ISysRoleService sysRoleService;

	@Autowired
	private ISysUserRoleService sysUserRoleService;

	@Autowired
	private ISysPermissionService sysPermissionService;

	@Autowired
	private ISysDeptService sysDeptService;

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
		//设置角色列表  （ID）
		List<Integer> roleIds = sysRoleService.findRoleIdByUserId(sysUser.getUserId());
		userInfo.setRoles(roleIds);
		//设置权限列表（permission）
		Set<String> permissions = sysPermissionService.findPermsByUserId(sysUser.getUserId());
		userInfo.setPermissions(permissions);
		return userInfo;
	}

	@Override
	public SysUser findByUsername(String username) {
		return sysUserMapper.selectByUsername(username);
	}

	@Override
	public PageInfo<SysUser> findByPage(SysUserDTO sysUserDTO) {
		List<Integer> deptList = new ArrayList<>();
		if (sysUserDTO.getDeptId()!=null && sysUserDTO.getDeptId()>0){
			deptList = sysDeptService.findChildrenById(sysUserDTO.getDeptId());
			deptList.add(sysUserDTO.getDeptId());
		}
		if (!StringUtils.isEmpty(sysUserDTO.getPageNum()) && !StringUtils.isEmpty(sysUserDTO.getPageSize())) {
			PageHelper.startPage(sysUserDTO.getPageNum(), sysUserDTO.getPageSize());
		}
		List<SysUser> list = sysUserMapper.selectBySearch(sysUserDTO.getUserName(), sysUserDTO.getStatus(),deptList);
		PageInfo<SysUser> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public UserInfo findById(Integer userId) {
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
		UserInfo userInfo = new UserInfo();
		BeanUtils.copyProperties(sysUser,userInfo);
		userInfo.setPassword(null);
		//设置角色列表
		List<Integer> roleIds = sysRoleService.findRoleIdByUserId(sysUser.getUserId());
		userInfo.setRoles(roleIds);
		return userInfo;
	}

	@Override
	@Transactional
	public void addUser(SysUserDTO sysUserDTO){
		int cnt = findUserIsExists(sysUserDTO.getUserName(),sysUserDTO.getUserId());
		if(cnt > 0){
			throw new BizException("5001","用户已存在");
		}
		//保存用户信息
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(sysUserDTO,sysUser);
		//获取盐值，生成用户密码
		String salt = BCrypt.gensalt();
		sysUser.setPassword(BCrypt.hashpw(sysUserDTO.getPassword() , salt));
		sysUser.setSalt(salt);
		sysUserMapper.insertSelective(sysUser);

		//添加用户角色关联关系信息
		sysUserRoleService.insertBatch(sysUserDTO.getRoles(),sysUser.getUserId());
	}

	@Override
	@Transactional
	public void editUser(SysUserDTO sysUserDTO){
		int cnt = findUserIsExists(sysUserDTO.getUserName(),sysUserDTO.getUserId());
		if(cnt > 0){
			throw new BizException("5001","用户已存在");
		}
		//修改用户基本信息
		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(sysUserDTO,sysUser);
		sysUser.setPassword(null);
		sysUserMapper.updateByPrimaryKeySelective(sysUser);

		//清除用户角色关联关系
		sysUserRoleService.deleteByUserId(sysUserDTO.getUserId());

		//添加用户角色关联关系信息
		sysUserRoleService.insertBatch(sysUserDTO.getRoles(),sysUser.getUserId());
	}

	@Override
	public void changeStatus(SysUserDTO sysUserDTO){
		//修改用户状态
		SysUser oldSysUser = sysUserMapper.selectByPrimaryKey(sysUserDTO.getUserId());
		if (oldSysUser==null){
			throw new BizException("5001","用户不存在");
		}
		SysUser sysUser = new SysUser();
		sysUser.setUserId(sysUserDTO.getUserId());
		sysUser.setStatus(sysUserDTO.getStatus());
		sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}

	@Override
	@Transactional
	public void deleteById(Integer userId){
		SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
		if (sysUser==null){
			throw new BizException("5001","用户不存在");
		}
		SysUser newSysUser = new SysUser();

		newSysUser.setUserId(userId);
		newSysUser.setDelFlag(CommonConstants.STATUS_DEL);
		sysUserMapper.updateByPrimaryKeySelective(newSysUser);

		//清除用户角色关联关系
		sysUserRoleService.deleteByUserId(userId);
		//清除用户角色关联关系
	}

	@Override
	public void resetPwd(ChangePasswordDTO changePasswordDTO) {
		SysUser oldSysUser = sysUserMapper.selectByPrimaryKey(changePasswordDTO.getUserId());
		if (oldSysUser==null){
			throw new BizException("5001","用户不存在");
		}
		SysUser sysUser = new SysUser();
		//获取盐值，生成用户密码
		String salt = BCrypt.gensalt();
		sysUser.setUserId(changePasswordDTO.getUserId());
		sysUser.setPassword(BCrypt.hashpw(changePasswordDTO.getNewpassword() , salt));
		sysUser.setSalt(salt);
		sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}

	/**
	 * 查询用户用户名否存在
	 * @param username
	 * @param id
	 * @return
	 */
	public int findUserIsExists(String username,Integer id){
		return sysUserMapper.selectUserIsExists(username,id);
	}
}
