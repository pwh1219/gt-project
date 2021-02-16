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
 * 商品入库，存储入库的信息
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EnterGoods对象", description="商品入库，存储入库的信息")
public class EnterGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品入库主键")
    @TableId(value = "enter_id", type = IdType.AUTO)
    private Integer enterId;

    @ApiModelProperty(value = "仓库名称")
    private byte[] repositoryName;

    @ApiModelProperty(value = "进入仓库的类型：1表示采购入库,2表示调拨入库,3表示其它入库")
    private String enterType;

    @ApiModelProperty(value = "入库时间")
    private Date applicationDate;

    @ApiModelProperty(value = "货物来源")
    private String soureceGoods;

    @ApiModelProperty(value = "获取来源联系人")
    private byte[] linkman;

    @ApiModelProperty(value = "入库经手人")
    private String userName;

    @ApiModelProperty(value = "0表示未付款,1表示已付款")
    private String payStatus;

    @ApiModelProperty(value = "1表示现金,2表示转账,3表示其它")
    private String payType;

    @ApiModelProperty(value = "入库审核状态:1表示未审核,2表示已审核,3表示驳回,4表示已领取,5表示申请中")
    private String auditStatus;

    @ApiModelProperty(value = "审核时间")
    private Date auditTime;

    @ApiModelProperty(value = "单据数量")
    private Integer invoicesAmount;

    @ApiModelProperty(value = "总共字符金额")
    private Double total;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "单据图片地址")
    private String invoicesImage;

    @ApiModelProperty(value = "逻辑删除：0表示未删除,1表示已删除")
    private String enterDelete;

    public Integer getEnterId() {
        return enterId;
    }

    public void setEnterId(Integer enterId) {
        this.enterId = enterId;
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

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getSoureceGoods() {
        return soureceGoods;
    }

    public void setSoureceGoods(String soureceGoods) {
        this.soureceGoods = soureceGoods;
    }

    public byte[] getLinkman() {
        return linkman;
    }

    public void setLinkman(byte[] linkman) {
        this.linkman = linkman;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getInvoicesAmount() {
        return invoicesAmount;
    }

    public void setInvoicesAmount(Integer invoicesAmount) {
        this.invoicesAmount = invoicesAmount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInvoicesImage() {
        return invoicesImage;
    }

    public void setInvoicesImage(String invoicesImage) {
        this.invoicesImage = invoicesImage;
    }

    public String getEnterDelete() {
        return enterDelete;
    }

    public void setEnterDelete(String enterDelete) {
        this.enterDelete = enterDelete;
    }
}
