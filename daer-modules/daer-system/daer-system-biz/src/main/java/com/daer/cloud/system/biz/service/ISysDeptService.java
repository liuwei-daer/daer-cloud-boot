package com.daer.cloud.system.biz.service;

import com.daer.cloud.system.biz.dto.DeptTree;

import java.util.List;

/**
 * @author liuwei
 * @date 2019-11-24
 */
public interface ISysDeptService {

	/**
	 * 查询用户信息
	 * @return userInfo
	 */
	List<DeptTree> findDetpTree();

}
