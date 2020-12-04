package com.daer.cloud.system.biz.controller;

import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.common.security.annotation.Inner;
import com.daer.cloud.common.security.service.AuthUser;
import com.daer.cloud.common.security.util.SecurityUtils;
import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.biz.service.ISysUserService;
import com.daer.cloud.system.biz.model.SysUser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

	private final ISysUserService userService;

	/**
	 * 获取当前用户全部信息
	 *
	 * @return 用户信息
	 */
	@GetMapping("/info")
	public Result<UserInfo> currentUser(Principal principal) {
		String username = principal.getName();
		SysUser user = userService.findByusername(username);
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
		SysUser user = userService.findByusername(username);
		if (user == null) {
			return Result.failed(String.format("用户信息为空 %s", username));
		}
		return Result.ok(userService.getUserInfo(user));
	}

	/**
	 * 通过ID查询用户信息
	 *
	 * @param id ID
	 * @return 用户信息
	 */
	@GetMapping("/{id}")
	public Result user(@PathVariable Integer id) {
		return Result.ok(userService.findById(id));
	}

}
