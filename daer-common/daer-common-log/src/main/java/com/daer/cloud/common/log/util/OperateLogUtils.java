package com.daer.cloud.common.log.util;

import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HttpUtil;
import com.daer.cloud.common.log.vo.OperatLogVO;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author liuwei
 * @date 2020-12-07
 */
@UtilityClass
public class OperateLogUtils {

    public OperatLogVO getOperateLog() {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        OperatLogVO operatLog = new OperatLogVO();
        operatLog.setCreateBy(Objects.requireNonNull(getUsername()));
        operatLog.setType(LogTypeEnum.NORMAL.getType());
        operatLog.setRemoteAddr(ServletUtil.getClientIP(request));
        operatLog.setRequestUri(URLUtil.getPath(request.getRequestURI()));
        operatLog.setMethod(request.getMethod());
        operatLog.setUserAgent(request.getHeader("user-agent"));
        operatLog.setParams(HttpUtil.toParams(request.getParameterMap()));
        operatLog.setServiceId(getClientId());
        return operatLog;
    }

    /**
     * 获取客户端
     * @return clientId
     */
    private String getClientId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            OAuth2Authentication auth2Authentication = (OAuth2Authentication) authentication;
            return auth2Authentication.getOAuth2Request().getClientId();
        }
        return null;
    }


    /**
     * 获取用户名称
     * @return username
     */
    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getName();
    }
}
