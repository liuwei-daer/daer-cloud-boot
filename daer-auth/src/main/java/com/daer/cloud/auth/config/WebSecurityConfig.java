package com.daer.cloud.auth.config;

import com.daer.cloud.auth.service.CustUserDetailsServiceImpl;
import com.daer.cloud.common.security.config.FilterIgnoreProperties;
import com.daer.cloud.common.security.handler.UnauthorizedEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author liuwei
 * @date 2018-02-08
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FilterIgnoreProperties filterIgnoreProperties;

    @Autowired
    private CustUserDetailsServiceImpl userDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .exceptionHandling()
            .authenticationEntryPoint(new UnauthorizedEntryPoint())
            .and()
            .authorizeRequests()
            .anyRequest().authenticated()
            .and().httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        String[] urls = new String[filterIgnoreProperties.getUrls().size()];
        urls = filterIgnoreProperties.getUrls().toArray(urls);
        web.ignoring()
                .antMatchers(HttpMethod.OPTIONS)
                .antMatchers(urls);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
