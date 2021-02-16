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
 * 商品出库关联表
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutInfo对象", description="商品出库关联表")
public class OutInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "没有意义主键")
    @TableId(value = "out_goods_id", type = IdType.AUTO)
    private Integer outGoodsId;

    @ApiModelProperty(value = "出库主键编号")
    private Integer outId;

    @ApiModelProperty(value = "商品主键")
    private Integer goodsId;

    public Integer getOutGoodsId() {
        return outGoodsId;
    }

    public void setOutGoodsId(Integer outGoodsId) {
        this.outGoodsId = outGoodsId;
    }

    public Integer getOutId() {
        return outId;
    }

    public void setOutId(Integer outId) {
        this.outId = outId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
