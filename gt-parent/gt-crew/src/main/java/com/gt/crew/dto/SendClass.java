package com.gt.crew.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 派班管理表
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-13
 */
public class SendClass extends Model<SendClass> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    @TableId(value = "class_id", type = IdType.AUTO)
    private Integer classId;

    /**
     * 铁路局，见系统参数
     */
    private String railways;

    private String kyd;

    /**
     * 子公司，见系统参数
     */
    private String filiale;

    /**
     * 出乘日期
     */
    private LocalDateTime rideDate;

    /**
     * 交路名称，指向交路
     */
    private Integer payId;

    private String payName;

    /**
     * 班组名称，指向班组
     */
    private Integer teamId;

    private String teamNum;

    /**
     * 交路类型，见系统参数
     */
    private String payType;

    /**
     * 出乘人员，存储id
     */
    private String rideMan;

    /**
     * 是否停运，1表示是，0表示否
     */
    private String isStop;

    private String remark;

    /**
     * 前车出乘人员
     */
    private String frontMan;

    /**
     * 后车出乘人员
     */
    private String backMan;


    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
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

    public LocalDateTime getRideDate() {
        return rideDate;
    }

    public void setRideDate(LocalDateTime rideDate) {
        this.rideDate = rideDate;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(String teamNum) {
        this.teamNum = teamNum;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getRideMan() {
        return rideMan;
    }

    public void setRideMan(String rideMan) {
        this.rideMan = rideMan;
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

    public String getFrontMan() {
        return frontMan;
    }

    public void setFrontMan(String frontMan) {
        this.frontMan = frontMan;
    }

    public String getBackMan() {
        return backMan;
    }

    public void setBackMan(String backMan) {
        this.backMan = backMan;
    }

    @Override
    protected Serializable pkVal() {
        return this.classId;
    }

    @Override
    public String toString() {
        return "SendClass{" +
        "classId=" + classId +
        ", railways=" + railways +
        ", kyd=" + kyd +
        ", filiale=" + filiale +
        ", rideDate=" + rideDate +
        ", payId=" + payId +
        ", payName=" + payName +
        ", teamId=" + teamId +
        ", teamNum=" + teamNum +
        ", payType=" + payType +
        ", rideMan=" + rideMan +
        ", isStop=" + isStop +
        ", remark=" + remark +
        ", frontMan=" + frontMan +
        ", backMan=" + backMan +
        "}";
    }
}
