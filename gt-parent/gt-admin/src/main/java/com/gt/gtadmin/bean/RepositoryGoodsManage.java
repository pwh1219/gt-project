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
 * 仓库商品库存管理表
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="RepositoryGoodsManage对象", description="仓库商品库存管理表")
public class RepositoryGoodsManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号主键")
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    @ApiModelProperty(value = "分公司名称")
    private String filialeName;

    @ApiModelProperty(value = "仓库名称")
    private String repositoryName;

    @ApiModelProperty(value = "商品名称")
    private byte[] goodsName;

    @ApiModelProperty(value = "库存商品数量")
    private Integer stocks;

    @ApiModelProperty(value = "库存(下限)最小值")
    private Integer minimum;

    @ApiModelProperty(value = "出库价格")
    private Double outPrice;

    @ApiModelProperty(value = "零售价")
    private Double retailPrice;

    @ApiModelProperty(value = "进入仓库的类型：1表示采购入库,2表示调拨入库,3表示其它入库")
    private String enterType;

    @ApiModelProperty(value = "首次入库时间")
    private Date firstTime;

    @ApiModelProperty(value = "最后出库时间")
    private Date lastTime;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getFilialeName() {
        return filialeName;
    }

    public void setFilialeName(String filialeName) {
        this.filialeName = filialeName;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public byte[] getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(byte[] goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getStocks() {
        return stocks;
    }

    public void setStocks(Integer stocks) {
        this.stocks = stocks;
    }

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Double getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(Double outPrice) {
        this.outPrice = outPrice;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getEnterType() {
        return enterType;
    }

    public void setEnterType(String enterType) {
        this.enterType = enterType;
    }

    public Date getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(Date firstTime) {
        this.firstTime = firstTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}
