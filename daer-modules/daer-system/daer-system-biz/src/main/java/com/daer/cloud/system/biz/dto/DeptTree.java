package com.daer.cloud.system.biz.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lengleng
 * @date 2019/2/1 部门树
 */
@Data
public class DeptTree implements Serializable {

	protected int id;

	protected int parentId;

	private String name;

	protected List<DeptTree> children = new ArrayList<DeptTree>();

}
