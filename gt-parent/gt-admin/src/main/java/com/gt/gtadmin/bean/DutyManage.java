package com.gt.gtadmin.bean;

import java.util.Date;

public class DutyManage {
    private Integer dutyId;

    private Integer dutyIdentity;

    private String dutyName;

    private String dutyStatus;

    private Date dutyTime;

    public Integer getDutyId() {
        return dutyId;
    }

    public void setDutyId(Integer dutyId) {
        this.dutyId = dutyId;
    }

    public Integer getDutyIdentity() {
        return dutyIdentity;
    }

    public void setDutyIdentity(Integer dutyIdentity) {
        this.dutyIdentity = dutyIdentity;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public String getDutyStatus() {
        return dutyStatus;
    }

    public void setDutyStatus(String dutyStatus) {
        this.dutyStatus = dutyStatus;
    }

    public Date getDutyTime() {
        return dutyTime;
    }

    public void setDutyTime(Date dutyTime) {
        this.dutyTime = dutyTime;
    }
}