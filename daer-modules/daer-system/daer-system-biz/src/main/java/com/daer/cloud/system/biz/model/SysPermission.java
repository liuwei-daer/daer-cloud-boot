package com.daer.cloud.system.biz.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_permission")
public class SysPermission {
    /**
     * 菜单ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 菜单名称
     */
    @Column(name = "perms_name")
    private String permsName;

    /**
     * 菜单编号
     */
    @Column(name = "perms_code")
    private String permsCode;

    /**
     * 菜单标识
     */
    @Column(name = "perms_key")
    private String permsKey;

    /**
     * 菜单布局
     */
    private String component;

    /**
     * 父菜单ID
     */
    @Column(name = "parent_code")
    private String parentCode;

    /**
     * 模块ID
     */
    @Column(name = "model_id")
    private String modelId;

    /**
     * 打开方式
     */
    private String target;

    /**
     * 显示顺序
     */
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @Column(name = "perms_type")
    private String permsType;

    /**
     * 菜单状态（0显示 1隐藏）
     */
    private String visible;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 链接
     */
    private String path;

    /**
     * 重定向
     */
    private String redirect;

    /**
     * 强制菜单显示为Item而不是SubItem
     */
    @Column(name = "hidden_children")
    private Boolean hiddenChildren;

    /**
     * 特殊 隐藏 PageHeader 组件中的页面带的 面包屑和页面标题栏
     */
    @Column(name = "hidden_header")
    private Boolean hiddenHeader;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标识：0：未删除，1：删除
     */
    @Column(name = "del_flag")
    private String delFlag;

    /**
     * 获取菜单ID
     *
     * @return id - 菜单ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置菜单ID
     *
     * @param id 菜单ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取菜单名称
     *
     * @return perms_name - 菜单名称
     */
    public String getPermsName() {
        return permsName;
    }

    /**
     * 设置菜单名称
     *
     * @param permsName 菜单名称
     */
    public void setPermsName(String permsName) {
        this.permsName = permsName == null ? null : permsName.trim();
    }

    /**
     * 获取菜单编号
     *
     * @return perms_code - 菜单编号
     */
    public String getPermsCode() {
        return permsCode;
    }

    /**
     * 设置菜单编号
     *
     * @param permsCode 菜单编号
     */
    public void setPermsCode(String permsCode) {
        this.permsCode = permsCode == null ? null : permsCode.trim();
    }

    /**
     * 获取菜单标识
     *
     * @return perms_key - 菜单标识
     */
    public String getPermsKey() {
        return permsKey;
    }

    /**
     * 设置菜单标识
     *
     * @param permsKey 菜单标识
     */
    public void setPermsKey(String permsKey) {
        this.permsKey = permsKey == null ? null : permsKey.trim();
    }

    /**
     * 获取菜单布局
     *
     * @return component - 菜单布局
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置菜单布局
     *
     * @param component 菜单布局
     */
    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    /**
     * 获取父菜单ID
     *
     * @return parent_code - 父菜单ID
     */
    public String getParentCode() {
        return parentCode;
    }

    /**
     * 设置父菜单ID
     *
     * @param parentCode 父菜单ID
     */
    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    /**
     * 获取模块ID
     *
     * @return model_id - 模块ID
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * 设置模块ID
     *
     * @param modelId 模块ID
     */
    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    /**
     * 获取打开方式
     *
     * @return target - 打开方式
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置打开方式
     *
     * @param target 打开方式
     */
    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    /**
     * 获取显示顺序
     *
     * @return order_num - 显示顺序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 设置显示顺序
     *
     * @param orderNum 显示顺序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取菜单类型（M目录 C菜单 F按钮）
     *
     * @return perms_type - 菜单类型（M目录 C菜单 F按钮）
     */
    public String getPermsType() {
        return permsType;
    }

    /**
     * 设置菜单类型（M目录 C菜单 F按钮）
     *
     * @param permsType 菜单类型（M目录 C菜单 F按钮）
     */
    public void setPermsType(String permsType) {
        this.permsType = permsType == null ? null : permsType.trim();
    }

    /**
     * 获取菜单状态（0显示 1隐藏）
     *
     * @return visible - 菜单状态（0显示 1隐藏）
     */
    public String getVisible() {
        return visible;
    }

    /**
     * 设置菜单状态（0显示 1隐藏）
     *
     * @param visible 菜单状态（0显示 1隐藏）
     */
    public void setVisible(String visible) {
        this.visible = visible == null ? null : visible.trim();
    }

    /**
     * 获取权限标识
     *
     * @return perms - 权限标识
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 设置权限标识
     *
     * @param perms 权限标识
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * 获取菜单图标
     *
     * @return icon - 菜单图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单图标
     *
     * @param icon 菜单图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取链接
     *
     * @return path - 链接
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置链接
     *
     * @param path 链接
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取重定向
     *
     * @return redirect - 重定向
     */
    public String getRedirect() {
        return redirect;
    }

    /**
     * 设置重定向
     *
     * @param redirect 重定向
     */
    public void setRedirect(String redirect) {
        this.redirect = redirect == null ? null : redirect.trim();
    }

    /**
     * 获取强制菜单显示为Item而不是SubItem
     *
     * @return hidden_children - 强制菜单显示为Item而不是SubItem
     */
    public Boolean getHiddenChildren() {
        return hiddenChildren;
    }

    /**
     * 设置强制菜单显示为Item而不是SubItem
     *
     * @param hiddenChildren 强制菜单显示为Item而不是SubItem
     */
    public void setHiddenChildren(Boolean hiddenChildren) {
        this.hiddenChildren = hiddenChildren;
    }

    /**
     * 获取特殊 隐藏 PageHeader 组件中的页面带的 面包屑和页面标题栏
     *
     * @return hidden_header - 特殊 隐藏 PageHeader 组件中的页面带的 面包屑和页面标题栏
     */
    public Boolean getHiddenHeader() {
        return hiddenHeader;
    }

    /**
     * 设置特殊 隐藏 PageHeader 组件中的页面带的 面包屑和页面标题栏
     *
     * @param hiddenHeader 特殊 隐藏 PageHeader 组件中的页面带的 面包屑和页面标题栏
     */
    public void setHiddenHeader(Boolean hiddenHeader) {
        this.hiddenHeader = hiddenHeader;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取删除标识：0：未删除，1：删除
     *
     * @return del_flag - 删除标识：0：未删除，1：删除
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标识：0：未删除，1：删除
     *
     * @param delFlag 删除标识：0：未删除，1：删除
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}