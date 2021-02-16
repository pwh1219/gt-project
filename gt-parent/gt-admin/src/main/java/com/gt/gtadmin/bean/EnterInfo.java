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
 * 商品入库关联表
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EnterInfo对象", description="商品入库关联表")
public class EnterInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "没有意义主键")
    @TableId(value = "enter_goods_id", type = IdType.AUTO)
    private Integer enterGoodsId;

    @ApiModelProperty(value = "商品入库主键")
    private Integer enterId;

    @ApiModelProperty(value = "商品主键")
    private Integer goodsId;

    public Integer getEnterGoodsId() {
        return enterGoodsId;
    }

    public void setEnterGoodsId(Integer enterGoodsId) {
        this.enterGoodsId = enterGoodsId;
    }

    public Integer getEnterId() {
        return enterId;
    }

    public void setEnterId(Integer enterId) {
        this.enterId = enterId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
