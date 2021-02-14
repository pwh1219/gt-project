package com.gt.crew.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 车次管理表
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-13
 */
public class TrainNum extends Model<TrainNum> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增
     */
    @TableId(value = "train_id", type = IdType.AUTO)
    private Integer trainId;

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
     * 车次号
     */
    private String trainNum;

    /**
     * 列车类型
     */
    private String trainType;

    /**
     * 始发地
     */
    private String startingAds;

    /**
     * 目的地
     */
    private String endingAds;

    /**
     * 出发时间
     */
    private LocalDateTime startingTime;

    /**
     * 结束时间
     */
    private LocalDateTime endingTime;

    /**
     * 行程天数
     */
    private Integer intervalDay;

    /**
     * 几天后出发
     */
    private Integer afterTime;

    /**
     * 是否停运，1表示是，0表示否
     */
    private String isStop;

    /**
     * 是否可用，1表示可用，0表示禁用
     */
    private String isAble;

    private String remark;

    private String isDel;


    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
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

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
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

    public Integer getAfterTime() {
        return afterTime;
    }

    public void setAfterTime(Integer afterTime) {
        this.afterTime = afterTime;
    }

    public String getIsStop() {
        return isStop;
    }

    public void setIsStop(String isStop) {
        this.isStop = isStop;
    }

    public String getIsAble() {
        return isAble;
    }

    public void setIsAble(String isAble) {
        this.isAble = isAble;
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
        return this.trainId;
    }

    @Override
    public String toString() {
        return "TrainNum{" +
        "trainId=" + trainId +
        ", railways=" + railways +
        ", kyd=" + kyd +
        ", filiale=" + filiale +
        ", trainNum=" + trainNum +
        ", trainType=" + trainType +
        ", startingAds=" + startingAds +
        ", endingAds=" + endingAds +
        ", startingTime=" + startingTime +
        ", endingTime=" + endingTime +
        ", intervalDay=" + intervalDay +
        ", afterTime=" + afterTime +
        ", isStop=" + isStop +
        ", isAble=" + isAble +
        ", remark=" + remark +
        ", isDel=" + isDel +
        "}";
    }
}
