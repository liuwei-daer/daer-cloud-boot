package com.daer.cloud.auth.endpoint;

import com.daer.cloud.common.core.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


/**
 * @author liuwei
 * @date 2019-11-24
 * 删除token端点
 */
@FrameworkEndpoint
public class CustomTokenEndpoint {

	@Autowired
	@Qualifier("consumerTokenServices")
	ConsumerTokenServices consumerTokenServices;

	@ResponseBody
	@RequestMapping(method = RequestMethod.DELETE, value = "/oauth/token")
	public ResponseEntity<Result> revokeToken(String access_token) {
		Result result = new Result<>();
		HttpStatus status = HttpStatus.OK;
		if (consumerTokenServices.revokeToken(access_token)){
			result.setSuccess(true);
			result.setCode(HttpServletResponse.SC_OK);
			result.setMessage("注销成功!");
		} else{
			status = HttpStatus.BAD_REQUEST;
			result.setSuccess(false);
			result.setCode(1002);
			result.setMessage("注销失败!");
		}
		return new ResponseEntity<Result>(result, status);
	}
}
