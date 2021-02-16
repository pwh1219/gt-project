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
 * 部门班组关联表
 * </p>
 *
 * @author z
 * @since 2021-02-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="DeptTeam对象", description="部门班组关联表")
public class DeptTeam implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "没有意义主键")
    @TableId(value = "dept_team_id", type = IdType.AUTO)
    private Integer deptTeamId;

    @ApiModelProperty(value = "主键")
    private Integer deptId;

    @ApiModelProperty(value = "主键")
    private Integer teamId;

    public Integer getDeptTeamId() {
        return deptTeamId;
    }

    public void setDeptTeamId(Integer deptTeamId) {
        this.deptTeamId = deptTeamId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
