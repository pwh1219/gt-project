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
 * 职务管理
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DutyManage对象", description="职务管理")
public class DutyManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "职务主键")
    @TableId(value = "duty_id", type = IdType.AUTO)
    private Integer dutyId;

    @ApiModelProperty(value = "职务id")
    private Integer dutyIdentity;

    @ApiModelProperty(value = "职务名称")
    private String dutyName;

    @ApiModelProperty(value = "启用 状态:0表示禁用,1表示启用")
    private String dutyStatus;

    @ApiModelProperty(value = "职务创建时间")
    private Date dutyTime;

    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    public Integer getDutyIdentity() {
        return dutyIdentity;
    }

    public void setDutyIdentity(Integer dutyIdentity) {
        this.dutyIdentity = dutyIdentity;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public String getDutyStatus() {
        return dutyStatus;
    }

    public void setDutyStatus(String dutyStatus) {
        this.dutyStatus = dutyStatus;
    }

    public Date getDutyTime() {
        return dutyTime;
    }

    public void setDutyTime(Date dutyTime) {
        this.dutyTime = dutyTime;
    }
}
