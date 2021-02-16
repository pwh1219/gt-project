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
 * 
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="InvoiceGoods对象", description="")
public class InvoiceGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单据编号")
    private Integer invoiceId;

    @ApiModelProperty(value = "商品主键")
    private Integer goodsId;

    @ApiModelProperty(value = "主键")
    @TableId(value = "invoice_goods_id", type = IdType.AUTO)
    private Integer invoiceGoodsId;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getInvoiceGoodsId() {
        return invoiceGoodsId;
    }

    public void setInvoiceGoodsId(Integer invoiceGoodsId) {
        this.invoiceGoodsId = invoiceGoodsId;
    }
}
