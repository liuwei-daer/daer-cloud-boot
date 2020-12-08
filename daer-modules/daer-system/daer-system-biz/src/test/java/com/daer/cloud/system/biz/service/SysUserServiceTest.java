package com.daer.cloud.system.biz.service;

import com.daer.cloud.system.SystemApplication;
import com.daer.cloud.system.biz.model.SysUser;
import com.daer.cloud.system.api.dto.UserInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liuwei
 * @date 2020-11-26
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= SystemApplication.class)
public class SysUserServiceTest {

    @Autowired
    ISysUserService sysUserService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getUserInfoTest() throws Exception {
        SysUser sysUser = sysUserService.findByUsername("admin");
        UserInfo userInfo = sysUserService.getUserInfo(sysUser);
        log.info("userInfo:{}",objectMapper.writeValueAsString(userInfo));
    }
}
