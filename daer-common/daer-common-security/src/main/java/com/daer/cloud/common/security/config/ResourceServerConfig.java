package com.daer.cloud.common.security.config;

import com.daer.cloud.common.security.handler.CustomAccessDeniedHandler;
import com.daer.cloud.common.security.handler.CustomOAuth2AuthenticationEntryPoint;
import com.daer.cloud.common.security.handler.UnauthorizedEntryPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;



@Slf4j
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private FilterIgnoreProperties filterIgnoreProperties;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] urls = new String[filterIgnoreProperties.getUrls().size()];
        urls = filterIgnoreProperties.getUrls().toArray(urls);
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new UnauthorizedEntryPoint())
                .and()
                .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler())
                .and()
                .authorizeRequests()
                .antMatchers(urls).permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer configurer) throws Exception {
        configurer
                .authenticationEntryPoint(new CustomOAuth2AuthenticationEntryPoint())
                .accessDeniedHandler(new CustomAccessDeniedHandler());
    }

}

