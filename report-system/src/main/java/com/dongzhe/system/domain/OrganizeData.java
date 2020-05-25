package com.dongzhe.system.domain;

public class OrganizeData {
    /**  客户名称*/
    private String customerName;
    /** 地址*/
    private String address;
    /** 联系电话*/
    private String contactNumber;
    /** 合同编号*/
    private String contractCode;
    /** 经费*/
    private String price;
    /** 检测项目*/
    private String checkItem;
    /** 产品方法*/
    private String productMethod;
    /** 方法编号*/
    private String methodCode;
    /** 检出限*/
    private String checkLimt;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public String getProductMethod() {
        return productMethod;
    }

    public void setProductMethod(String productMethod) {
        this.productMethod = productMethod;
    }

    public String getMethodCode() {
        return methodCode;
    }

    public void setMethodCode(String methodCode) {
        this.methodCode = methodCode;
    }

    public String getCheckLimt() {
        return checkLimt;
    }

    public void setCheckLimt(String checkLimt) {
        this.checkLimt = checkLimt;
    }
}