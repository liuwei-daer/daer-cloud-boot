package com.daer.cloud.system.biz.dto;

import lombok.Data;

/**
 * Created by work on 2017/6/6.
 */
@Data
public class ChangePasswordDTO {

    private int userId;

    private String password;

    private String newpassword;

    private String newpasswordagain;
}
