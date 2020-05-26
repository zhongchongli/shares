package com.dongzhe.project.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class BaseShareDO implements Serializable {

    /**
     * 股票编码
     */
    private String code;

    /**
     * 股票名称
     */
    private String name;

    /**
     * 股票简称
     */
    private String shortCode;

    /**
     * 上市日期
     */
    private Date startDay;

    /**
     * 股票类型 sh:上海 sz:深圳 zx
     */
    private String codeType;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
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
        BaseShareDO other = (BaseShareDO) that;
        return (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getShortCode() == null ? other.getShortCode() == null : this.getShortCode().equals(other.getShortCode()))
            && (this.getStartDay() == null ? other.getStartDay() == null : this.getStartDay().equals(other.getStartDay()))
            && (this.getCodeType() == null ? other.getCodeType() == null : this.getCodeType().equals(other.getCodeType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getShortCode() == null) ? 0 : getShortCode().hashCode());
        result = prime * result + ((getStartDay() == null) ? 0 : getStartDay().hashCode());
        result = prime * result + ((getCodeType() == null) ? 0 : getCodeType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", shortCode=").append(shortCode);
        sb.append(", startDay=").append(startDay);
        sb.append(", codeType=").append(codeType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}