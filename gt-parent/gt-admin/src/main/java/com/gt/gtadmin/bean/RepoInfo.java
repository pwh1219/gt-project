package com.gt.gtadmin.bean;

import java.util.Date;

public class RepoInfo {
    private Integer repositoryId;

    private String repositoryName;

    private String railwaysBureauName;

    private String passengerSectionName;

    private String filialeName;

    private Date createTime;

    private String repositoryDelete;

    private String principal;

    private String manager;

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