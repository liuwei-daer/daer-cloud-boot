package com.daer.cloud.system.biz.controller;

import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.common.security.annotation.Inner;
import com.daer.cloud.common.security.service.AuthUser;
import com.daer.cloud.common.security.util.SecurityUtils;
import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.biz.dto.PermissionTree;
import com.daer.cloud.system.biz.model.SysPermission;
import com.daer.cloud.system.biz.model.SysUser;
import com.daer.cloud.system.biz.service.ISysPermissionService;
import com.daer.cloud.system.biz.service.ISysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/perms")
public class PermissionController {

	private final ISysUserService userService;

	private final ISysPermissionService permissionService;

	/**
	 * 获取当前用户菜单
	 *
	 * @return 用户信息
	 */
	@GetMapping("/user")
	public Result<List<PermissionTree>> currentUserPerms(Principal principal) {

		String username = principal.getName();
		SysUser user = userService.findByusername(username);
		return Result.ok(permissionService.findMenuByUserId(user.getId()));
	}

}
