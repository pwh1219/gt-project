package com.gt.gtadmin.bean;

import java.util.Date;

public class InvoiceAudit {
    private Integer invoiceId;

    private String enterType;

    private String outType;

    private Date applicationDate;

    private Date startTime;

    private String auditStatus;

    private String userName;

    private Date auditTime;

    private Integer applicantNumber;

    private String auditor;

    private String remark;

    private String auditType;

    private String outAccept;

    private Double total;

    private Integer invoicesAmount;

    private String invoicesImage;

    private String enterSource;

    private String payType;

    private String payStatus;

    private String applicant;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getEnterType() {
        return enterType;
    }

    public void setEnterType(String enterType) {
        this.enterType = enterType;
    }

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getApplicantNumber() {
        return applicantNumber;
    }

    public void setApplicantNumber(Integer applicantNumber) {
        this.applicantNumber = applicantNumber;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getOutAccept() {
        return outAccept;
    }

    public void setOutAccept(String outAccept) {
        this.outAccept = outAccept;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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

    public String getEnterSource() {
        return enterSource;
    }

    public void setEnterSource(String enterSource) {
        this.enterSource = enterSource;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }
}