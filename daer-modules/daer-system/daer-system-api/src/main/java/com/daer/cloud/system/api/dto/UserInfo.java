package com.daer.cloud.system.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@Data
public class UserInfo implements Serializable {

	private static final long serialVersionUID = -1499891383307579238L;

	/**
	 * 用户ID
	 */
	private Integer userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 用户密码
	 */
	private String password;

	/**
	 * 用户名
	 */
	private String realName;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 用户邮箱
	 */
	private String email;

	/**
	 * 用户性别（1男 2女 3未知）
	 */
	private String sex;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 帐号状态（0正常 1停用）
	 */
	private String status;

	/**
	 * 0-正常，1-删除
	 */
	private String delFlag;

	/**
	 * 权限标识集合
	 */
	private Set<String> permissions;

	/**
	 * 角色集合
	 */
	private List<Integer> roles;
}
