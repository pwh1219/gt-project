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
 * 班组管理
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TeamManage对象", description="班组管理")
public class TeamManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "team_id", type = IdType.AUTO)
    private Integer teamId;

    @ApiModelProperty(value = "铁路局名称")
    private String railwayName;

    @ApiModelProperty(value = "客运段名称")
    private String trafficName;

    @ApiModelProperty(value = "分公司名称")
    private String filialeName;

    @ApiModelProperty(value = "班组编号")
    private String teamIdentity;

    @ApiModelProperty(value = "班组名称")
    private byte[] teamName;

    @ApiModelProperty(value = "班组类型")
    private String teamType;

    @ApiModelProperty(value = "班组组长")
    private String teamLeader;

    @ApiModelProperty(value = "班组成员")
    private String teamMember;

    @ApiModelProperty(value = "列车类型：1表示快速(K),2表示特快(T),3表示直达(Z),4表示高铁,5表示动车,6表示城际,7表示普快")
    private String trainType;

    @ApiModelProperty(value = "0表示未启用,1表示启用")
    private String hotTeamStatus;

    @ApiModelProperty(value = "0表示未删除,1表示删除")
    private String teamDelete;

    @ApiModelProperty(value = "0表示未启用,1表示启用")
    private String teamStatus;

    @ApiModelProperty(value = "备注")
    private String remark;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getRailwayName() {
        return railwayName;
    }

    public void setRailwayName(String railwayName) {
        this.railwayName = railwayName;
    }

    public String getTrafficName() {
        return trafficName;
    }

    public void setTrafficName(String trafficName) {
        this.trafficName = trafficName;
    }

    public String getFilialeName() {
        return filialeName;
    }

    public void setFilialeName(String filialeName) {
        this.filialeName = filialeName;
    }

    public String getTeamIdentity() {
        return teamIdentity;
    }

    public void setTeamIdentity(String teamIdentity) {
        this.teamIdentity = teamIdentity;
    }

    public byte[] getTeamName() {
        return teamName;
    }

    public void setTeamName(byte[] teamName) {
        this.teamName = teamName;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public String getTeamLeader() {
        return teamLeader;
    }

    public void setTeamLeader(String teamLeader) {
        this.teamLeader = teamLeader;
    }

    public String getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getHotTeamStatus() {
        return hotTeamStatus;
    }

    public void setHotTeamStatus(String hotTeamStatus) {
        this.hotTeamStatus = hotTeamStatus;
    }

    public String getTeamDelete() {
        return teamDelete;
    }

    public void setTeamDelete(String teamDelete) {
        this.teamDelete = teamDelete;
    }

    public String getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(String teamStatus) {
        this.teamStatus = teamStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
