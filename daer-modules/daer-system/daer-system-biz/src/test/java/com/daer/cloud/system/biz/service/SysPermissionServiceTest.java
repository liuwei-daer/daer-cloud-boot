package com.daer.cloud.system.biz.service;

import com.daer.cloud.system.SystemApplication;
import com.daer.cloud.system.biz.model.SysPermission;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * @author liuwei
 * @date 2020-11-26
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= SystemApplication.class)
public class SysPermissionServiceTest {

    @Autowired
    ISysPermissionService sysPermissionService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void findPermsByUserIdTest() throws Exception {
        Set<String> permsSet = sysPermissionService.findPermsByUserId(1);
        log.debug("permsSet is : {}",permsSet);
    }

    @Test
    public void findByUserIdTest() throws Exception {
        List<SysPermission> permissionList = sysPermissionService.findByUserId(1);
        log.debug("permissionList is : {}",objectMapper.writeValueAsString(permissionList));
    }
}
