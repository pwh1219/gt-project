package com.gt.gtadmin.bean;

import java.util.Date;

public class RoleManage {
    private Integer roleId;

    private String roleStatus;

    private Date roleCreateTime;

    private String roleDelete;

    private byte[] roleName;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public Date getRoleCreateTime() {
        return roleCreateTime;
    }

    public void setRoleCreateTime(Date roleCreateTime) {
        this.roleCreateTime = roleCreateTime;
    }

    public String getRoleDelete() {
        return roleDelete;
    }

    public void setRoleDelete(String roleDelete) {
        this.roleDelete = roleDelete;
    }

    public byte[] getRoleName() {
        return roleName;
    }

    public void setRoleName(byte[] roleName) {
        this.roleName = roleName;
    }
}