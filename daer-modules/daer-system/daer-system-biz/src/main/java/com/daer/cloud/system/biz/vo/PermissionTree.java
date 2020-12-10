package com.daer.cloud.system.biz.vo;

import com.daer.cloud.system.biz.model.SysPermission;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwei
 * @date 2020-12-04
 */
@Data
public class PermissionTree extends SysPermission {

    private List<PermissionTree> children = new ArrayList<PermissionTree>();
}
