package com.daer.cloud.system.biz.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_param")
public class SysParam {
    /**
     * 系统参数ID
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 系统参数KEY
     */
    @Column(name = "param_key")
    private String paramKey;

    /**
     * 系统参数值
     */
    @Column(name = "param_value")
    private String paramValue;

    /**
     * 系统参数名称
     */
    @Column(name = "param_name")
    private String paramName;

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
     * 获取系统参数ID
     *
     * @return id - 系统参数ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置系统参数ID
     *
     * @param id 系统参数ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取系统参数KEY
     *
     * @return param_key - 系统参数KEY
     */
    public String getParamKey() {
        return paramKey;
    }

    /**
     * 设置系统参数KEY
     *
     * @param paramKey 系统参数KEY
     */
    public void setParamKey(String paramKey) {
        this.paramKey = paramKey == null ? null : paramKey.trim();
    }

    /**
     * 获取系统参数值
     *
     * @return param_value - 系统参数值
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * 设置系统参数值
     *
     * @param paramValue 系统参数值
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    /**
     * 获取系统参数名称
     *
     * @return param_name - 系统参数名称
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * 设置系统参数名称
     *
     * @param paramName 系统参数名称
     */
    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
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