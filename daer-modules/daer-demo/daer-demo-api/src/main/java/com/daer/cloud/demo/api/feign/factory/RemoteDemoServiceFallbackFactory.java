package com.daer.cloud.demo.api.feign.factory;

import com.daer.cloud.demo.api.feign.RemoteDemoService;
import com.daer.cloud.demo.api.feign.fallback.RemoteDemoServiceFallbackImpl;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@Component
public class RemoteDemoServiceFallbackFactory implements FallbackFactory<RemoteDemoService> {

	@Override
	public RemoteDemoService create(Throwable throwable) {
		RemoteDemoServiceFallbackImpl remoteDemoServiceFallback = new RemoteDemoServiceFallbackImpl();
		remoteDemoServiceFallback.setCause(throwable);
		return remoteDemoServiceFallback;
	}
}
