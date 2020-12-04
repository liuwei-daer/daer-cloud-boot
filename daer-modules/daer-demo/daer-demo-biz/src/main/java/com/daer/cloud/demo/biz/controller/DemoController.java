package com.daer.cloud.demo.biz.controller;


import com.daer.cloud.common.core.constant.SecurityConstants;
import com.daer.cloud.common.core.util.Result;
import com.daer.cloud.system.api.feign.RemoteUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    RemoteUserService remoteUserService;

    /**
     * 获取指定用户全部信息
     *
     * @return 用户信息
     */
    @GetMapping("/info")
    public Result info() {
        log.info("11111");
        return Result.ok("demo info is ok");
    }


    @GetMapping("/userinfo/{username}")
    public Result userinfo(@PathVariable String username) {
        log.info("22222");
        log.info("remoteUserService :{}",remoteUserService);
        Result result = remoteUserService.info(username, SecurityConstants.FROM_IN);
        if (result!=null) {
            return result;
        } else {
            return Result.failed("远程调用失败");
        }

    }

}
