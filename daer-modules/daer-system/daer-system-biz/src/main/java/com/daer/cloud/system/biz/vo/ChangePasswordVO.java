package com.daer.cloud.system.biz.vo;

import lombok.Data;

/**
 * Created by work on 2017/6/6.
 */
@Data
public class ChangePasswordVO {

    private String password;
    private String newpassword;
    private String newpasswordagain;
}
