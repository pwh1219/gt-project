package com.gt.gtadmin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 审核单据
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="InvoiceAudit对象", description="审核单据")
public class InvoiceAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单据编号")
    @TableId(value = "invoice_id", type = IdType.AUTO)
    private Integer invoiceId;

    @ApiModelProperty(value = "仓库名称")
    private byte[] repositoryName;

    @ApiModelProperty(value = "出库类型：1表示采购入库,2表示调拨入库,3表示其它入库")
    private String enterType;

    @ApiModelProperty(value = "出库类型：1表示其它出库,2表示配货出库")
    private String outType;

    @ApiModelProperty(value = "联系人")
    private byte[] contacts;

    @ApiModelProperty(value = "接收方名称")
    private byte[] acceptName;

    @ApiModelProperty(value = "入库时间")
    private Date applicationDate;

    @ApiModelProperty(value = "交路编号")
    private byte[] wayNumber;

    @ApiModelProperty(value = "交路出发时间")
    private Date startTime;

    @ApiModelProperty(value = "入库审核状态:1表示未审核,2表示已审核,3表示驳回,4表示已领取,5表示申请中")
    private String auditStatus;

    @ApiModelProperty(value = "入库经手人")
    private String userName;

    @ApiModelProperty(value = "审核时间")
    private Date auditTime;

    @ApiModelProperty(value = "申请人编号")
    private Integer applicantNumber;

    @ApiModelProperty(value = "审核人")
    private String auditor;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "1表示领用,2表示退库,3表示报损,4表示调拨")
    private String auditType;

    @ApiModelProperty(value = "出库接收方")
    private String outAccept;

    @ApiModelProperty(value = "总金额")
    private Double total;

    @ApiModelProperty(value = "单据数量")
    private Integer invoicesAmount;

    @ApiModelProperty(value = "单据图片地址")
    private String invoicesImage;

    @ApiModelProperty(value = "商品入库来源")
    private String enterSource;

    @ApiModelProperty(value = "1表示现金,2表示转账,3表示其它")
    private String payType;

    @ApiModelProperty(value = "0表示未付款,1表示已付款")
    private String payStatus;

    @ApiModelProperty(value = "申请人")
    private String applicant;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public byte[] getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(byte[] repositoryName) {
        this.repositoryName = repositoryName;
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

    public byte[] getContacts() {
        return contacts;
    }

    public void setContacts(byte[] contacts) {
        this.contacts = contacts;
    }

    public byte[] getAcceptName() {
        return acceptName;
    }

    public void setAcceptName(byte[] acceptName) {
        this.acceptName = acceptName;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public byte[] getWayNumber() {
        return wayNumber;
    }

    public void setWayNumber(byte[] wayNumber) {
        this.wayNumber = wayNumber;
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
