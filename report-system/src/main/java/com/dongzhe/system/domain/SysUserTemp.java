package com.dongzhe.system.domain;

import com.dongzhe.common.annotation.Excel;

import java.io.Serializable;

/**
 * @author 
 */
public class SysUserTemp implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 部门ID
     */
    private Integer deptId;

    /**
     * 采样分组标识
     */
    private Integer sampleGroupId;

    /**
     * 是否组长（1：是）
     */
    private String isLeader;

    private Long createBy;

    /**
     * 委托协议id
     */
    private Long agreementId;

    /** 部门对象 */
    @Excel(name = "部门名称", targetAttr = "deptName", type = Excel.Type.EXPORT)
    private SysDept dept;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getSampleGroupId() {
        return sampleGroupId;
    }

    public void setSampleGroupId(Integer sampleGroupId) {
        this.sampleGroupId = sampleGroupId;
    }

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public SysDept getDept()
    {
        if (dept == null)
        {
            dept = new SysDept();
        }
        return dept;
    }

    public void setDept(SysDept dept)
    {
        this.dept = dept;
    }

    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysUserTemp other = (SysUserTemp) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getSampleGroupId() == null ? other.getSampleGroupId() == null : this.getSampleGroupId().equals(other.getSampleGroupId()))
            && (this.getIsLeader() == null ? other.getIsLeader() == null : this.getIsLeader().equals(other.getIsLeader()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getAgreementId() == null ? other.getAgreementId() == null : this.getAgreementId().equals(other.getAgreementId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getSampleGroupId() == null) ? 0 : getSampleGroupId().hashCode());
        result = prime * result + ((getIsLeader() == null) ? 0 : getIsLeader().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getAgreementId() == null) ? 0 : getAgreementId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", deptId=").append(deptId);
        sb.append(", sampleGroupId=").append(sampleGroupId);
        sb.append(", isLeader=").append(isLeader);
        sb.append(", createBy=").append(createBy);
        sb.append(", agreementId=").append(agreementId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}