package com.daer.cloud.system.biz.controller;

import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.common.log.annotation.OperateLog;
import com.daer.cloud.common.security.annotation.Inner;
import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.biz.vo.ChangePasswordVO;
import com.daer.cloud.system.biz.vo.SysUserVO;
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
	@OperateLog(value = "查询用户信息列表")
	public Result<PageInfo<SysUser>> list(@RequestBody SysUserVO sysUserVO) {
		return Result.ok(userService.findByPage(sysUserVO));
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
	@OperateLog(value = "新增后台用户信息")
	public Result<?> add(@RequestBody SysUserVO sysUserVO) {
		Result result = new Result<>();
		return result;
	}

	@ResponseBody
	@PostMapping(value = "/update")
	@OperateLog(value = "修改用户信息")
	public Result<?> update(@RequestBody SysUserVO sysUserVO) {
		Result result = new Result<>();
		//获取用户手机号码是否存在
		return result;
	}

	@ResponseBody
	@OperateLog(value = "删除后台用户信息")
	@DeleteMapping(value = "/delete/{id}")
	public Result<?> delete(@PathVariable("id") final int id) {
		Result result = new Result<>();
		return result;
	}

	@ResponseBody
	@OperateLog(value = "用户修改密码")
	@PostMapping(value = "/changePwd")
	public Result<?> changePwd(@RequestBody ChangePasswordVO changePasswordVO) {
//		ShiroUser shiroUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		Result result = new Result<>();
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
		return result;
	}


}
