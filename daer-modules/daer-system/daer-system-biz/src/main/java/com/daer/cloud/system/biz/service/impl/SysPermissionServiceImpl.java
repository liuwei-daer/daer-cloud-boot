package com.daer.cloud.system.biz.service.impl;

import com.daer.cloud.system.biz.dto.PermissionDTO;
import com.daer.cloud.system.biz.model.SysUser;
import com.daer.cloud.system.biz.vo.PermissionTree;
import com.daer.cloud.system.biz.mapper.SysPermissionMapper;
import com.daer.cloud.system.biz.model.SysPermission;
import com.daer.cloud.system.biz.service.ISysPermissionService;
import com.daer.cloud.system.biz.vo.PermsSelTree;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author liuwei
 *  @date 2020-12-07
 */
@Slf4j
@Service
public class SysPermissionServiceImpl implements ISysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public Set<String> findPermsByUserId(Integer userId) {
        return sysPermissionMapper.selectPermsByUserId(userId);
    }

    @Override
    public List<SysPermission> findByUserId(Integer userId) {
        return sysPermissionMapper.selectByUserId(userId);
    }

    @Override
    public List<PermissionTree> findMenuByUserId(Integer userId) {
        return sysPermissionMapper.selectMenuByUserId(userId);
    }

    @Override
    public List<PermissionTree> findTreeByUser(PermissionDTO permissionDTO) {
        List<SysPermission> dataList = new ArrayList<>();
        if (permissionDTO.getUserName().equals("admin")){
            dataList = sysPermissionMapper.selectAll();
        } else {
            dataList = findByUserId(permissionDTO.getUserId());
        }
        List<PermissionTree> treeData = buildTreeData(dataList);
        return treeData;
    }

    @Override
    public List<PermsSelTree> findSelTreeByUser(SysUser sysUser) {
        List<SysPermission> dataList = new ArrayList<>();
        if (sysUser.getUserName().equals("admin")){
            dataList = sysPermissionMapper.selectAll();
        } else {
            dataList = findByUserId(sysUser.getUserId());
        }
        List<PermsSelTree> treeData = buildSelTreeData(dataList);
        return treeData;
    }



    /**
     * 生成菜单树
     *
     * */
    private List<PermissionTree> buildTreeData(List<SysPermission> resourceList) {
        List<PermissionTree> dataList = new ArrayList<>();
        resourceList.forEach(sysPermission -> {
            PermissionTree permissionTree = new PermissionTree();
            BeanUtils.copyProperties(sysPermission,permissionTree);
            dataList.add(permissionTree);
        });
//        return dataList;
        List<PermissionTree> nodeList = new ArrayList<>();
        dataList.forEach(r1 -> {
            boolean mark = false;
            for (PermissionTree r2 : dataList) {
                if (r1.getParentCode().equals( r2.getPermsCode())) {
                    mark = true;
                    if (r2.getChildren() == null) {
                        r2.setChildren(new ArrayList());
                    }
                    r2.getChildren().add(r1);
                    break;
                }
            }
            if (!mark) {
                nodeList.add(r1);
            }
        });
        return nodeList;
    }

    /**
     * 生成下拉树
     *
     * */
    private List<PermsSelTree> buildSelTreeData(List<SysPermission> resourceList) {
        List<PermsSelTree> dataList = new ArrayList<>();
        resourceList.forEach(sysPermission -> {
            PermsSelTree permsSelTree = new PermsSelTree();
            permsSelTree.setKey(sysPermission.getPermsCode());
            permsSelTree.setValue(sysPermission.getPermsCode());
            permsSelTree.setParentId(sysPermission.getParentCode());
            permsSelTree.setTitle(sysPermission.getPermsName());
            dataList.add(permsSelTree);
        });
//        return dataList;
        List<PermsSelTree> nodeList = new ArrayList<>();
        dataList.forEach(r1 -> {
            boolean mark = false;
            for (PermsSelTree r2 : dataList) {
                if (r1.getParentId().equals( r2.getKey())) {
                    mark = true;
                    if (r2.getChildren() == null) {
                        r2.setChildren(new ArrayList());
                    }
                    r2.getChildren().add(r1);
                    break;
                }
            }
            if (!mark) {
                nodeList.add(r1);
            }
        });
        return nodeList;
    }

    /**
     * 判断当前节点是(false)否(true)存在子节点
     * @param permissions
     * @param permsCode
     * @return
     *
     */
    public boolean checkIsExistChildNode(List<SysPermission> permissions, String permsCode) {
        boolean flag = true;
        for (SysPermission sysPermission : permissions) {
            if (sysPermission.getParentCode().equals(permsCode) ) flag = false;
        }
        return flag;
    }
}
