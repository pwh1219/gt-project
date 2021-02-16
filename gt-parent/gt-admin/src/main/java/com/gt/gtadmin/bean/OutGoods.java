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
 * 商品出库
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutGoods对象", description="商品出库")
public class OutGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出库主键编号")
    @TableId(value = "out_id", type = IdType.AUTO)
    private Integer outId;

    @ApiModelProperty(value = "仓库名称")
    private byte[] repositoryName;

    @ApiModelProperty(value = "出库类型：1表示其它入库")
    private String outType;

    @ApiModelProperty(value = "出库接收方")
    private String outAccpet;

    private byte[] acceptName;

    @ApiModelProperty(value = "入库经手人")
    private String userName;

    @ApiModelProperty(value = "入库时间")
    private Date applicationDate;

    @ApiModelProperty(value = "总金额")
    private Double total;

    @ApiModelProperty(value = "入库审核状态:1表示未审核,2表示已审核,3表示驳回,4表示已领取,5表示申请中")
    private String auditStatus;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "单据数量")
    private Integer invoicesAmount;

    @ApiModelProperty(value = "单据图片地址")
    private String invoicesImage;

    @ApiModelProperty(value = "审核时间")
    private Date auditTime;

    @ApiModelProperty(value = "逻辑删除：0表示未删除,1表示已删除")
    private String outDelete;

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public byte[] getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(byte[] repositoryName) {
        this.repositoryName = repositoryName;
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

    public byte[] getAcceptName() {
        return acceptName;
    }

    public void setAcceptName(byte[] acceptName) {
        this.acceptName = acceptName;
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
