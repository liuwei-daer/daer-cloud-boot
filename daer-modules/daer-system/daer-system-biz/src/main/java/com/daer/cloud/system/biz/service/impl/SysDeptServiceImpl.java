package com.daer.cloud.system.biz.service.impl;

import com.daer.cloud.common.core.constant.CommonConstants;
import com.daer.cloud.system.biz.vo.DeptTree;
import com.daer.cloud.system.biz.mapper.SysDeptMapper;
import com.daer.cloud.system.biz.model.SysDept;
import com.daer.cloud.system.biz.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuwei
 * @date 2020-12-07
 */
@Service
public class SysDeptServiceImpl implements ISysDeptService {

    @Autowired
    SysDeptMapper sysDeptMapper;

    @Override
    public List<DeptTree> findDeptTree() {
        SysDept sysDept = new SysDept();
        sysDept.setStatus(CommonConstants.STATUS_NORMAL);
        sysDept.setDelFlag(CommonConstants.STATUS_NORMAL);
        return buildDeptTreeData(sysDeptMapper.select(sysDept));
    }

    @Override
    public List<Integer> findChildrenById(Integer id) {
        return sysDeptMapper.selectChildrenById(id);
    }

    /**
     * 生成菜单树
     *
     * */
    public List<DeptTree> buildDeptTreeData(List<SysDept> deptList) {
        List<DeptTree> dataList = new ArrayList<>();
        deptList.forEach(dept -> {
            DeptTree deptTree = new DeptTree();
            deptTree.setId(dept.getId());
            deptTree.setParentId(dept.getParentId());
            deptTree.setName(dept.getDeptName());
            dataList.add(deptTree);
        });

//        List<DeptTree> nodeList = new ArrayList<>();
//        dataList.forEach(r1 -> {
//            boolean mark = false;
//            for (DeptTree r2 : dataList) {
//                if (r1.getParentId()==r2.getId()) {
//                    mark = true;
//                    if (r2.getChildren() == null) {
//                        r2.setChildren(new ArrayList());
//                    }
//                    r2.getChildren().add(r1);
//                    break;
//                }
//            }
//            if (!mark) {
//                nodeList.add(r1);
//            }
//        });
        return dataList;
    }
}
