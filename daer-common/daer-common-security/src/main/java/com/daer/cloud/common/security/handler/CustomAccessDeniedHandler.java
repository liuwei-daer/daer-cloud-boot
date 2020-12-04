package com.daer.cloud.common.security.handler;


import com.daer.cloud.common.core.constant.CommonConstants;
import com.daer.cloud.common.core.util.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuwei
 * @date 2018-04-19
 */
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setCharacterEncoding(CommonConstants.UTF8);
        response.setContentType(CommonConstants.CONTENT_TYPE);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        Result result = new Result<>();
        result.setSuccess(false);
        result.setCode(HttpServletResponse.SC_FORBIDDEN);
        result.setMessage("无权限访问!");
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
