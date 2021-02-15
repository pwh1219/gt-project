package com.gt.employee.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 职务管理表
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-14
 */
public class Duty extends Model<Duty> {

    private static final long serialVersionUID = 1L;

    /**
     * 职务标识
     */
    @TableId(value = "duty_tag", type = IdType.AUTO)
    private String dutyTag;

    /**
     * 职务名称
     */
    private String dutyName;

    /**
     * 是否启用，1表示启用，0表示禁用
     */
    private String isAble;

    /**
     * 职务创建时间
     */
    private LocalDateTime dutyCtime;

    /**
     * 职务修改时间
     */
    private LocalDateTime dutyUtime;


    public String getDutyTag() {
        return dutyTag;
    }

    public void setDutyTag(String dutyTag) {
        this.dutyTag = dutyTag;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public String getIsAble() {
        return isAble;
    }

    public void setIsAble(String isAble) {
        this.isAble = isAble;
    }

    public LocalDateTime getDutyCtime() {
        return dutyCtime;
    }

    public void setDutyCtime(LocalDateTime dutyCtime) {
        this.dutyCtime = dutyCtime;
    }

    public LocalDateTime getDutyUtime() {
        return dutyUtime;
    }

    public void setDutyUtime(LocalDateTime dutyUtime) {
        this.dutyUtime = dutyUtime;
    }

    @Override
    protected Serializable pkVal() {
        return this.dutyTag;
    }

    @Override
    public String toString() {
        return "Duty{" +
        "dutyTag=" + dutyTag +
        ", dutyName=" + dutyName +
        ", isAble=" + isAble +
        ", dutyCtime=" + dutyCtime +
        ", dutyUtime=" + dutyUtime +
        "}";
    }
}
