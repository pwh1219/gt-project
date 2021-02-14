package com.gt.crew.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 交路管理表
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-13
 */
public class PayWay extends Model<PayWay> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    @TableId(value = "pay_id", type = IdType.AUTO)
    private Integer payId;

    /**
     * 铁路局，见系统参数
     */
    private String railways;

    /**
     * 客运段，见系统参数
     */
    private String kyd;

    /**
     * 分公司，见系统参数
     */
    private String filiale;

    /**
     * 列车类型，见系统参数
     */
    private String trainType;

    /**
     * 交路名称
     */
    private String payName;

    /**
     * 车次
     */
    private String trainNum;

    /**
     * 出发地
     */
    private String startingAds;

    /**
     * 目的地
     */
    private String endingAds;

    /**
     * 始发时间
     */
    private LocalDateTime startingTime;

    /**
     * 结束时间
     */
    private LocalDateTime endingTime;

    /**
     * 间隔天数
     */
    private Integer intervalDay;

    /**
     * 是否停运，1表示是，0表示否
     */
    private String isStop;

    private String remark;

    private String isDel;


    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getRailways() {
        return railways;
    }

    public void setRailways(String railways) {
        this.railways = railways;
    }

    public String getKyd() {
        return kyd;
    }

    public void setKyd(String kyd) {
        this.kyd = kyd;
    }

    public String getFiliale() {
        return filiale;
    }

    public void setFiliale(String filiale) {
        this.filiale = filiale;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getStartingAds() {
        return startingAds;
    }

    public void setStartingAds(String startingAds) {
        this.startingAds = startingAds;
    }

    public String getEndingAds() {
        return endingAds;
    }

    public void setEndingAds(String endingAds) {
        this.endingAds = endingAds;
    }

    public LocalDateTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalDateTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalDateTime getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(LocalDateTime endingTime) {
        this.endingTime = endingTime;
    }

    public Integer getIntervalDay() {
        return intervalDay;
    }

    public void setIntervalDay(Integer intervalDay) {
        this.intervalDay = intervalDay;
    }

    public String getIsStop() {
        return isStop;
    }

    public void setIsStop(String isStop) {
        this.isStop = isStop;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    @Override
    protected Serializable pkVal() {
        return this.payId;
    }

    @Override
    public String toString() {
        return "PayWay{" +
        "payId=" + payId +
        ", railways=" + railways +
        ", kyd=" + kyd +
        ", filiale=" + filiale +
        ", trainType=" + trainType +
        ", payName=" + payName +
        ", trainNum=" + trainNum +
        ", startingAds=" + startingAds +
        ", endingAds=" + endingAds +
        ", startingTime=" + startingTime +
        ", endingTime=" + endingTime +
        ", intervalDay=" + intervalDay +
        ", isStop=" + isStop +
        ", remark=" + remark +
        ", isDel=" + isDel +
        "}";
    }
}
