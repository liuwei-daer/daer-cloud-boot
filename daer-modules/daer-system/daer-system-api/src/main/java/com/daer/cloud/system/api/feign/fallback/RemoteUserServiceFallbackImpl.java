package com.daer.cloud.system.api.feign.fallback;

import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.api.feign.RemoteUserService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@Slf4j
@Component
public class RemoteUserServiceFallbackImpl implements RemoteUserService {

	@Setter
	private Throwable cause;

	/**
	 * 通过用户名查询用户、角色信息
	 *
	 * @param username 用户名
	 * @return R
	 */
	@Override
	public Result<UserInfo> info(String username,String from) {
		log.error("feign 查询用户信息失败:{}", username, cause);
		return null;
	}

}
