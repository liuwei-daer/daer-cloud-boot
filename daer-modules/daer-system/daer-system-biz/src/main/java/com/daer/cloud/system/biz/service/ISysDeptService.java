package com.daer.cloud.system.biz.service;

import com.daer.cloud.system.biz.vo.DeptTree;

import java.util.List;

/**
 * @author liuwei
 * @date 2019-11-24
 */
public interface ISysDeptService {

	/**
	 * 查询部门列表
	 * @return List<DeptTree>
	 */
	List<DeptTree> findDeptTree();

	/**
	 * 根据部门ID查询该部门下所有子级部门
	 * @param id
	 * @return List<Integer>
	 */
	List<Integer> findChildrenById(Integer id);

}
