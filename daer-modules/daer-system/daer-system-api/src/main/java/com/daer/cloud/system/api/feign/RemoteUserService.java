

package com.daer.cloud.system.api.feign;

import com.daer.cloud.common.core.constant.SecurityConstants;
import com.daer.cloud.common.core.constant.ServiceNameConstants;
import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.system.api.dto.UserInfo;
import com.daer.cloud.system.api.feign.factory.RemoteUserServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author liuwei
 * @date 2019-11-24
 */
@FeignClient(name = ServiceNameConstants.SYSTEM_SERVICE,path = "/user",fallbackFactory = RemoteUserServiceFallbackFactory.class)
public interface RemoteUserService {
	/**
	 * 通过用户名查询用户、角色信息
	 *
	 * @param username 用户名
	 * @return R
	 */
	@GetMapping("/info/{username}")
	Result<UserInfo> info(@PathVariable(value = "username") String username, @RequestHeader(SecurityConstants.FROM) String from);

}
