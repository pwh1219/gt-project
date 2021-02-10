package com.gt.gtadmin.entity;

import java.util.Date;

public class SysUser {
    private String id;

    private String usercode;

    private String username;

    private String password;

    private String salt;

    private String organizationId;

    private String postId;

    private String phone;

    private String wxId;

    private String locked;

    private String remarks;

    private Date created;

    private Date updated;

    private String creater;

    private String operCode;

    private String status;

    private String operOrganizationId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getOperCode() {
        return operCode;
    }

    public void setOperCode(String operCode) {
        this.operCode = operCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperOrganizationId() {
        return operOrganizationId;
    }

    public void setOperOrganizationId(String operOrganizationId) {
        this.operOrganizationId = operOrganizationId;
    }

    @Override
    public String toString() {
        return "SysUser [id=" + id + ", usercode=" + usercode + ", username="
                + username + ", password=" + password + ", salt=" + salt
                + ", organizationId=" + organizationId + ", postId=" + postId
                + ", phone=" + phone + ", wxId=" + wxId + ", locked=" + locked
                + ", remarks=" + remarks + ", created=" + created
                + ", updated=" + updated + ", creater=" + creater
                + ", operCode=" + operCode + ", status=" + status
                + ", operOrganizationId=" + operOrganizationId + "]";
    }


}