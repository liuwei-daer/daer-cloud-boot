package com.daer.cloud.system.api.feign.factory;

import com.daer.cloud.system.api.feign.fallback.RemoteUserServiceFallbackImpl;
import com.daer.cloud.system.api.feign.RemoteUserService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@Component
public class RemoteUserServiceFallbackFactory implements FallbackFactory<RemoteUserService> {

	@Override
	public RemoteUserService create(Throwable throwable) {
		RemoteUserServiceFallbackImpl remoteUserServiceFallback = new RemoteUserServiceFallbackImpl();
		remoteUserServiceFallback.setCause(throwable);
		return remoteUserServiceFallback;
	}
}
