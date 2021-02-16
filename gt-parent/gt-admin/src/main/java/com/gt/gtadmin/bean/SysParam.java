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
 * 系统参数表，用来存放放到内存中使用的常用参数
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SysParam对象", description="系统参数表，用来存放放到内存中使用的常用参数")
public class SysParam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "系统参数编号，自增")
    @TableId(value = "sys_param_id", type = IdType.AUTO)
    private Long sysParamId;

    @ApiModelProperty(value = "系统参数字段")
    private String sysParamField;

    @ApiModelProperty(value = "系统参数字段值")
    private String sysParamValue;

    @ApiModelProperty(value = "系统参数字段文本内容")
    private String sysParamText;

    @ApiModelProperty(value = "系统特殊属性标记，1表示正常存的数据,2表示存的一条sql")
    private String sysParamType;


    public Long getSysParamId() {
        return sysParamId;
    }

    public void setSysParamId(Long sysParamId) {
        this.sysParamId = sysParamId;
    }

    public String getSysParamField() {
        return sysParamField;
    }

    public void setSysParamField(String sysParamField) {
        this.sysParamField = sysParamField;
    }

    public String getSysParamValue() {
        return sysParamValue;
    }

    public void setSysParamValue(String sysParamValue) {
        this.sysParamValue = sysParamValue;
    }

    public String getSysParamText() {
        return sysParamText;
    }

    public void setSysParamText(String sysParamText) {
        this.sysParamText = sysParamText;
    }

    public String getSysParamType() {
        return sysParamType;
    }

    public void setSysParamType(String sysParamType) {
        this.sysParamType = sysParamType;
    }
}
