package com.daer.cloud.auth.controller;

import com.oracle.tools.packager.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author liuwei
 * @date 2018-03-05
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public Principal user(Principal user){
        Log.info("user is in");
        return user;
    }
}