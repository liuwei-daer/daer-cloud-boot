package com.daer.cloud.common.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 定义有效期
 * @author liuwei
 * @date 2018-06-25
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "security.oauth2")
public class Oauth2Properties {
    /**
     * 1 支持多点登录 0 不支持
     */
    private Integer mutiLogin = 1;
    /**
     * token 有效期
     */
    private Integer accessTokenTime = 60 * 60 * 12;

}
