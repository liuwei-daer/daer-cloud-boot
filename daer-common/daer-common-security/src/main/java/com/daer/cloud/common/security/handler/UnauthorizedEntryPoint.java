package com.daer.cloud.common.security.handler;

import com.daer.cloud.common.core.constant.CommonConstants;
import com.daer.cloud.common.core.util.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuwei
 * @date 2018-02-28
 */
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setCharacterEncoding(CommonConstants.UTF8);
        response.setContentType(CommonConstants.CONTENT_TYPE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        Result result = new Result<>();
        result.setSuccess(false);
        result.setCode(HttpServletResponse.SC_UNAUTHORIZED);
        result.setMessage("用户未登录");
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }

}
