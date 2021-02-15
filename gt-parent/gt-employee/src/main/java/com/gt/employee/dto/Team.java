package com.gt.employee.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 班组表
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-14
 */
public class Team extends Model<Team> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    @TableId(value = "team_id", type = IdType.AUTO)
    private Integer teamId;

    /**
     * 班组名称
     */
    private String teamName;

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
     * 班组编号
     */
    private String teamNum;

    /**
     * 班组类型，见系统参数
     */
    private String teamType;

    private Integer teamLeader;

    /**
     * 班组成员，id用逗号分隔
     */
    private String teamMember;

    /**
     * 状态，1表示可用，0表示禁用
     */
    private String isAble;

    /**
     * 是否热备，1表示是，0表示否
     */
    private String isRb;

    /**
     * 备注
     */
    private String remark;

    /**
     * 列车类型，见系统参数
     */
    private String trainType;

    private String isDel;


    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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

    public String getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(String teamNum) {
        this.teamNum = teamNum;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public Integer getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(Integer teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
    }

    public String getIsAble() {
        return isAble;
    }

    public void setIsAble(String isAble) {
        this.isAble = isAble;
    }

    public String getIsRb() {
        return isRb;
    }

    public void setIsRb(String isRb) {
        this.isRb = isRb;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    @Override
    protected Serializable pkVal() {
        return this.teamId;
    }

    @Override
    public String toString() {
        return "Team{" +
        "teamId=" + teamId +
        ", teamName=" + teamName +
        ", railways=" + railways +
        ", kyd=" + kyd +
        ", filiale=" + filiale +
        ", teamNum=" + teamNum +
        ", teamType=" + teamType +
        ", teamLeader=" + teamLeader +
        ", teamMember=" + teamMember +
        ", isAble=" + isAble +
        ", isRb=" + isRb +
        ", remark=" + remark +
        ", trainType=" + trainType +
        ", isDel=" + isDel +
        "}";
    }
}
