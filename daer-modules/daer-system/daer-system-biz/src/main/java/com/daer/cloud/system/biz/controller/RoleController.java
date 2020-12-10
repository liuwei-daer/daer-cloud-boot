package com.daer.cloud.system.biz.controller;

import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.common.log.annotation.OperateLog;
import com.daer.cloud.system.biz.dto.SysRoleDTO;
import com.daer.cloud.system.biz.dto.SysUserDTO;
import com.daer.cloud.system.biz.model.SysUser;
import com.daer.cloud.system.biz.service.ISysRoleService;
import com.daer.cloud.system.biz.dto.RoleGrantFunDTO;
import com.daer.cloud.system.biz.model.SysRole;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author liuwei
 * @date 2019-11-24
 */
@Slf4j
@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	ISysRoleService sysRoleService;

	@ResponseBody
	@GetMapping(value = "/all")
	public Result<List<SysRole>> listAll() {
		return Result.ok(sysRoleService.findByAll());
	}

	@ResponseBody
	@GetMapping(value = "/info/{id}")
	public Result<?> info(@PathVariable("id") final int id) {
		Result<SysRole> result = new Result<>();
		result.setSuccess(true);
		return result;
	}

	@PostMapping("list")
	@OperateLog(value = "查询系统用户信息列表")
	public Result<PageInfo<SysRole>> list(@RequestBody SysRoleDTO sysRoleDTO) {
		return Result.ok(sysRoleService.findByPage(sysRoleDTO));
	}

	@ResponseBody
	@OperateLog(value = "新增角色信息")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody SysRole SysRole) {
		Result<String> result = new Result<>();
		result.setSuccess(true);
		return result;
	}

	@ResponseBody
	@OperateLog(value = "修改角色信息")
	@PostMapping(value = "/update")
	public Result<?> update(@RequestBody SysRole SysRole) {
		Result<String> result = new Result<>();
		return result;
	}

	@ResponseBody
	@OperateLog(value = "删除角色信息")
	@DeleteMapping(value = "/delete/{id}")
	public Result<?> delete(@PathVariable("id") final int id) {
		Result<String> result = new Result<>();
		result.setSuccess(true);
		return result;
	}

	@ResponseBody
	@OperateLog(value = "角色角色赋权")
	@PostMapping(value = "/grantFun")
	public Result<?> grantFun(@RequestBody RoleGrantFunDTO roleGrantFunDTO) {
		Result<String> result = new Result<>();
		result.setSuccess(true);
		return result;
	}

}
