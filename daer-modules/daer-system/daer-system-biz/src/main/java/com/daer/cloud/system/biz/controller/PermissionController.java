package com.daer.cloud.system.biz.controller;

import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.system.biz.dto.PermissionDTO;
import com.daer.cloud.system.biz.vo.PermissionTree;
import com.daer.cloud.system.biz.model.SysUser;
import com.daer.cloud.system.biz.service.ISysPermissionService;
import com.daer.cloud.system.biz.service.ISysUserService;
import com.daer.cloud.system.biz.vo.PermsSelTree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@Slf4j
@RestController
@RequestMapping("/perms")
public class PermissionController {

	@Autowired
	private ISysUserService userService;

	@Autowired
	private ISysPermissionService permissionService;

	/**
	 * 获取当前用户菜单
	 *
	 * @return 用户菜单信息
	 */
	@GetMapping("/user")
	public Result<List<PermissionTree>> currentUserPerms(Principal principal) {
		String username = principal.getName();
		SysUser user = userService.findByUsername(username);
		return Result.ok(permissionService.findMenuByUserId(user.getUserId()));
	}

	/**
	 * 获取当前用户菜单
	 *
	 * @return 用户菜单信息
	 */
	@PostMapping("/tree")
	public Result<List<PermissionTree>> tree(Principal principal, @RequestBody PermissionDTO permissionDTO) {
		String username = principal.getName();
		SysUser user = userService.findByUsername(username);
		permissionDTO.setUserId(user.getUserId());
		permissionDTO.setUserName(username);
		List<PermissionTree> treeList = permissionService.findTreeByUser(permissionDTO);
		return Result.ok(treeList);
	}

	/**
	 * 获取当前用户菜单
	 *
	 * @return 用户菜单信息
	 */
	@PostMapping("/selTree")
	public Result<List<PermsSelTree>> selTree(Principal principal) {
		String username = principal.getName();
		SysUser user = userService.findByUsername(username);
		List<PermsSelTree> treeList = permissionService.findSelTreeByUser(user);
		return Result.ok(treeList);
	}

}
