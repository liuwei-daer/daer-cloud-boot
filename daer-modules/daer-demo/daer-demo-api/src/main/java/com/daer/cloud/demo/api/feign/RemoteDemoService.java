package com.daer.cloud.demo.api.feign;

import com.daer.cloud.common.core.constant.ServiceNameConstants;
import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.demo.api.feign.factory.RemoteDemoServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@FeignClient(contextId = "remoteDemoService", value = ServiceNameConstants.DEMO_SERVICE, fallbackFactory = RemoteDemoServiceFallbackFactory.class)
public interface RemoteDemoService {
	/**
	 * 通过用户名查询用户、角色信息
	 *
	 * @return Result
	 */
	@GetMapping("/demo/info")
	Result<String> info();

}
