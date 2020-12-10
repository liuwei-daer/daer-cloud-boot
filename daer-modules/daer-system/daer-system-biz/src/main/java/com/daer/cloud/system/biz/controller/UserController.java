package com.daer.cloud.system.biz.controller;

import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.common.log.annotation.OperateLog;
import com.daer.cloud.common.security.annotation.Inner;
import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.biz.dto.ChangePasswordDTO;
import com.daer.cloud.system.biz.dto.SysUserDTO;
import com.daer.cloud.system.biz.service.ISysUserService;
import com.daer.cloud.system.biz.model.SysUser;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ISysUserService userService;

	/**
	 * 获取当前用户全部信息
	 *
	 * @return 用户信息
	 */
	@GetMapping("/info")
	public Result<UserInfo> currentUser(Principal principal) {
		String username = principal.getName();
		SysUser user = userService.findByUsername(username);
		if (user == null) {
			return Result.failed(String.format("用户信息为空 %s", username));
		}
		UserInfo userInfo = userService.getUserInfo(user);
		userInfo.setPassword(null);
		return Result.ok(userInfo);
	}

	/**
	 * 获取指定用户全部信息
	 *
	 * @return 用户信息
	 */
	@Inner
	@GetMapping("/info/{username}")
	public Result<UserInfo> info(@PathVariable(value = "username") String username) {
		SysUser user = userService.findByUsername(username);
		if (user == null) {
			return Result.failed(String.format("用户信息为空 %s", username));
		}
		return Result.ok(userService.getUserInfo(user));
	}

	/**
	 * 查询用户列表
	 */
	@PostMapping("list")
	@OperateLog(value = "查询系统用户信息列表")
	public Result<PageInfo<SysUser>> list(@RequestBody SysUserDTO sysUserDTO) {
		return Result.ok(userService.findByPage(sysUserDTO));
	}

	/**
	 * 通过ID查询用户信息
	 *
	 * @param id ID
	 * @return 用户信息
	 */
	@GetMapping("/{id}")
	public Result<UserInfo> user(@PathVariable Integer id) {
		return Result.ok(userService.findById(id));
	}

	@ResponseBody
	@PostMapping(value = "/add")
	@OperateLog(value = "新增系统用户信息")
	public Result<?> add(@RequestBody SysUserDTO sysUserDTO) {
		userService.addUser(sysUserDTO);
		return Result.ok();
	}

	@ResponseBody
	@PostMapping(value = "/edit")
	@OperateLog(value = "修改系统用户信息")
	public Result<?> update(@RequestBody SysUserDTO sysUserDTO) {
		userService.editUser(sysUserDTO);
		return Result.ok();
	}

	@ResponseBody
	@PostMapping(value = "/changeStatus")
	@OperateLog(value = "修改系统用户状态信息")
	public Result<?> changeStatus(@RequestBody SysUserDTO sysUserDTO) {
		userService.changeStatus(sysUserDTO);
		return Result.ok();
	}

	@ResponseBody
	@OperateLog(value = "删除系统用户信息")
	@DeleteMapping(value = "/delete/{id}")
	public Result<?> delete(@PathVariable("id") final int id) {
		userService.deleteById(id);
		return Result.ok();
	}


	@ResponseBody
	@OperateLog(value = "重置用户密码")
	@PostMapping(value = "/resetPwd")
	public Result<?> resetPwd(@RequestBody ChangePasswordDTO changePasswordDTO) {
		userService.resetPwd(changePasswordDTO);
		return Result.ok();
	}

	@ResponseBody
	@OperateLog(value = "用户修改密码")
	@PostMapping(value = "/changePwd")
	public Result<?> changePwd(@RequestBody ChangePasswordDTO changePasswordDTO) {
//		if(!BCrypt.checkpw(changePasswordDto.getPassword(),shiroUser.getPassword())){
//			//验证旧密码是否正确
//			throw new BizException(SysCode.CHANGEPWD_PWD_INCORRECT);
//		}
//		if(StringUtils.isEmpty(changePasswordDto.getNewpassword())){
//			//验证新密码是否为空
//			throw new BizException(SysCode.CHANGEPWD_PASSWORD_EMPTY);
//		}
//		if(changePasswordDto.getPassword().equals(changePasswordDto.getNewpassword())){
//			//新密码不能与旧密码相同
//			throw new BizException(SysCode.OLD_PASSWORD_NEQ);
//		}
//		if(!changePasswordDto.getNewpassword().equals(changePasswordDto.getNewpasswordagain())){
//			//验证两次新密码是否一致
//			throw new BizException(SysCode.CHANGEPWD_PASSWORD_NEQ);
//		}
//		AdminUser sysAdminUser = adminUserService.findByMobile(shiroUser.getMobile().toString());
//		AdminUser user = new AdminUser();
//		user.setId(sysAdminUser.getId());
//		String hashPwd = BCrypt.hashpw(changePasswordDto.getNewpassword(),sysAdminUser.getSalt());
//		user.setPassword(hashPwd);
//
//		adminUserService.updataPwdById(user);
//		UsernamePasswordToken token = new UsernamePasswordToken(shiroUser.getMobile().toString(), changePasswordDto.getNewpassword());
//		SecurityUtils.getSubject().login(token);
//		result.setSuccess(true);
		return Result.ok();
	}


}
