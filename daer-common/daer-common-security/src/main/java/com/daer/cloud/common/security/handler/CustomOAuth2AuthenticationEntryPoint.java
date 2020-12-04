package com.daer.cloud.common.security.handler;

import com.daer.cloud.common.core.util.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuwei
 * @date 2018-03-05
 */
@Slf4j
@Data
public class CustomOAuth2AuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        Result result = new Result<>();
        result.setSuccess(false);
        result.setCode(HttpServletResponse.SC_UNAUTHORIZED);
        result.setMessage("token无效!");
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }
}
