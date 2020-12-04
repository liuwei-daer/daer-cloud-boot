package com.daer.cloud.demo.api.feign.fallback;

import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.demo.api.feign.RemoteDemoService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@Slf4j
@Component
public class RemoteDemoServiceFallbackImpl implements RemoteDemoService {
	@Setter
	private Throwable cause;

	/**
	 * 通过用户名查询用户、角色信息
	 *
	 * @return R
	 */
	@Override
	public Result<String> info() {
		log.error("feign 查询用户信息失败:{}", cause);
		return null;
	}

}
