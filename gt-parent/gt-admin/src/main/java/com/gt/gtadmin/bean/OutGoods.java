package com.gt.gtadmin.bean;

import java.util.Date;

public class OutGoods {
    private Integer outId;

    private String outType;

    private String outAccpet;

    private String userName;

    private Date applicationDate;

    private Double total;

    private String auditStatus;

    private String remark;

    private Integer invoicesAmount;

    private String invoicesImage;

    private Date auditTime;

    private String outDelete;

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public String getOutAccpet() {
        return outAccpet;
    }

    public void setOutAccpet(String outAccpet) {
        this.outAccpet = outAccpet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getInvoicesAmount() {
        return invoicesAmount;
    }

    public void setInvoicesAmount(Integer invoicesAmount) {
        this.invoicesAmount = invoicesAmount;
    }

    public String getInvoicesImage() {
        return invoicesImage;
    }

    public void setInvoicesImage(String invoicesImage) {
        this.invoicesImage = invoicesImage;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getOutDelete() {
        return outDelete;
    }

    public void setOutDelete(String outDelete) {
        this.outDelete = outDelete;
    }
}