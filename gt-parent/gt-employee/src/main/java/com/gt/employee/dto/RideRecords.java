package com.gt.employee.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 出乘记录表
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-14
 */
public class RideRecords extends Model<RideRecords> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    @TableId(value = "record_id", type = IdType.AUTO)
    private Integer recordId;

    /**
     * 列车长id
     */
    private Integer conductor;

    /**
     * 出乘日期
     */
    private LocalDateTime rideTime;

    /**
     * 下乘时间
     */
    private LocalDateTime byTime;


    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Integer getConductor() {
        return conductor;
    }

    public void setConductor(Integer conductor) {
        this.conductor = conductor;
    }

    public LocalDateTime getRideTime() {
        return rideTime;
    }

    public void setRideTime(LocalDateTime rideTime) {
        this.rideTime = rideTime;
    }

    public LocalDateTime getByTime() {
        return byTime;
    }

    public void setByTime(LocalDateTime byTime) {
        this.byTime = byTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.recordId;
    }

    @Override
    public String toString() {
        return "RideRecords{" +
        "recordId=" + recordId +
        ", conductor=" + conductor +
        ", rideTime=" + rideTime +
        ", byTime=" + byTime +
        "}";
    }
}
