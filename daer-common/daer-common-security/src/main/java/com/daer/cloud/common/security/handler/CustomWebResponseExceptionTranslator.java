package com.daer.cloud.common.security.handler;

import com.daer.cloud.common.security.exception.CustomOauthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

/**
 * @author liuwei
 * @date 2018-07-09
 */
@Slf4j
@Component("customWebResponseExceptionTranslator")
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {

    @Override
    public ResponseEntity<OAuth2Exception> translate(Exception e) throws Exception {
        OAuth2Exception oAuth2Exception = null;
        if (e instanceof OAuth2Exception) {
            oAuth2Exception = (OAuth2Exception) e;
        } else {
            oAuth2Exception = new OAuth2Exception("500", e);
        }
        CustomOauthException customOauthException = new CustomOauthException(oAuth2Exception.getMessage());
        customOauthException.setErrorCode(oAuth2Exception.getOAuth2ErrorCode());
        return ResponseEntity
                .status(oAuth2Exception.getHttpErrorCode())
                .body(customOauthException);
    }
}
