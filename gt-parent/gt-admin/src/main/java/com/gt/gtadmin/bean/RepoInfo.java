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
 * 仓库信息管理，用来存放各个仓库的信息
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="RepoInfo对象", description="仓库信息管理，用来存放各个仓库的信息")
public class RepoInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "仓库主键，自增")
    @TableId(value = "repository_id", type = IdType.AUTO)
    private Integer repositoryId;

    @ApiModelProperty(value = "仓库名称")
    private String repositoryName;

    @ApiModelProperty(value = "铁路局名称")
    private String railwaysBureauName;

    @ApiModelProperty(value = "客运段名称")
    private String passengerSectionName;

    @ApiModelProperty(value = "分公司名称")
    private String filialeName;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "逻辑删除,0表示(false)未删除,1表示(true) 删除")
    private String repositoryDelete;

    @ApiModelProperty(value = "负责人")
    private String principal;

    @ApiModelProperty(value = "管理员")
    private String manager;

    @ApiModelProperty(value = "备注")
    private String remark;

    public Integer getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(Integer repositoryId) {
        this.repositoryId = repositoryId;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getRailwaysBureauName() {
        return railwaysBureauName;
    }

    public void setRailwaysBureauName(String railwaysBureauName) {
        this.railwaysBureauName = railwaysBureauName;
    }

    public String getPassengerSectionName() {
        return passengerSectionName;
    }

    public void setPassengerSectionName(String passengerSectionName) {
        this.passengerSectionName = passengerSectionName;
    }

    public String getFilialeName() {
        return filialeName;
    }

    public void setFilialeName(String filialeName) {
        this.filialeName = filialeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRepositoryDelete() {
        return repositoryDelete;
    }

    public void setRepositoryDelete(String repositoryDelete) {
        this.repositoryDelete = repositoryDelete;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
