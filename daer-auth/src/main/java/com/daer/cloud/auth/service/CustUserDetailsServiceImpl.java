package com.daer.cloud.auth.service;

import cn.hutool.core.util.StrUtil;
import com.daer.cloud.common.core.constant.CommonConstants;
import com.daer.cloud.common.core.constant.SecurityConstants;
import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.common.security.service.AuthUser;
import com.daer.cloud.demo.api.feign.RemoteDemoService;
import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.api.feign.RemoteUserService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户详细信息
 *
 * @author liuwei
 */
@Slf4j
@Service
@AllArgsConstructor
public class CustUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	RemoteUserService remoteUserService;

	@Autowired
	RemoteDemoService remoteDemoService;

	/**
	 * 用户密码登录
	 *
	 * @param username 用户名
	 * @return
	 */
	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String username) {
		Result<UserInfo> result = remoteUserService.info(username, SecurityConstants.FROM_IN);
		UserDetails userDetails = getUserDetails(result);
		return userDetails;
	}

	/**
	 * 构建userdetails
	 *
	 * @param result 用户信息
	 * @return
	 */
	private UserDetails getUserDetails(Result<UserInfo> result) {
		if (result == null || result.getData() == null) {
			throw new UsernameNotFoundException("用户不存在");
		}
		UserInfo info = result.getData();
		Set<String> dbAuthsSet = new HashSet<>();
		if (info.getPermissions()!=null && info.getPermissions().size()>0) {
			// 获取资源
			dbAuthsSet.addAll(info.getPermissions());
		}
		Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(dbAuthsSet.toArray(new String[0]));

		// 构造security用户
		return new AuthUser(info.getUserId(), info.getUsername(), info.getPassword(),
			StrUtil.equals(info.getStatus(), CommonConstants.STATUS_NORMAL), true, true, true, authorities);
	}
}
