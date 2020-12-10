package com.daer.cloud.system.biz.controller;

import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.system.biz.vo.DeptTree;
import com.daer.cloud.system.biz.service.ISysDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@Slf4j
@RestController
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private ISysDeptService sysDeptService;

	/**
	 * 获取当前用户菜单
	 *
	 * @return 用户菜单信息
	 */
	@GetMapping("/tree")
	public Result<List<DeptTree>> treeList() {
		return Result.ok(sysDeptService.findDeptTree());
	}

}
