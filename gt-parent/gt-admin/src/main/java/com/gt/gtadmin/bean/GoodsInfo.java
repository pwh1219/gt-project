package com.gt.gtadmin.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 商品明细表
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="GoodsInfo对象", description="商品明细表")
public class GoodsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品主键")
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品单位")
    private Double goodsUnits;

    @ApiModelProperty(value = "商品数量")
    private Integer goodsAmount;

    @ApiModelProperty(value = "出库价格")
    private Double goodsPrice;

    @ApiModelProperty(value = "说明")
    private String remark;

    @ApiModelProperty(value = "0表示未删除,1表示已删除")
    private String goodsDelete;

    @ApiModelProperty(value = "商品编号")
    private Integer goodsIdentity;

    @ApiModelProperty(value = "图片地址")
    private String goodsImage;

    @ApiModelProperty(value = "商品类别")
    private String goodsType;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsUnits() {
        return goodsUnits;
    }

    public void setGoodsUnits(Double goodsUnits) {
        this.goodsUnits = goodsUnits;
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGoodsDelete() {
        return goodsDelete;
    }

    public void setGoodsDelete(String goodsDelete) {
        this.goodsDelete = goodsDelete;
    }

    public Integer getGoodsIdentity() {
        return goodsIdentity;
    }

    public void setGoodsIdentity(Integer goodsIdentity) {
        this.goodsIdentity = goodsIdentity;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }
}
