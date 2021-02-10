package com.gt.gtadmin.bean;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;


@Repository
@Table(name = "sys_param") //mybatis通用接口mapper依赖JPA实体类采用JPA
public class SysParam implements Serializable {

    // 主键 自动递增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sysParamId;

    @Column(name = "sys_param_field")
    private String sysParamField;

    @Column(name = "sys_param_value")
    private String sysParamValue;

    @Column(name = "sys_param_text")
    private String sysParamText;

    @Column(name = "sys_param_type")
    private String sysParamType;

    public Long getSysParamId() {
        return sysParamId;
    }

    public void setSysParamId(Long sysParamId) {
        this.sysParamId = sysParamId;
    }

    public String getSysParamField() {
        return sysParamField;
    }

    public void setSysParamField(String sysParamField) {
        this.sysParamField = sysParamField;
    }

    public String getSysParamValue() {
        return sysParamValue;
    }

    public void setSysParamValue(String sysParamValue) {
        this.sysParamValue = sysParamValue;
    }

    public String getSysParamText() {
        return sysParamText;
    }

    public void setSysParamText(String sysParamText) {
        this.sysParamText = sysParamText;
    }

    public String getSysParamType() {
        return sysParamType;
    }

    public void setSysParamType(String sysParamType) {
        this.sysParamType = sysParamType;
    }

    @Override
    public String toString() {
        return "SysParam{" +
                "sysParamId=" + sysParamId +
                ", sysParamField='" + sysParamField + '\'' +
                ", sysParamValue='" + sysParamValue + '\'' +
                ", sysParamText='" + sysParamText + '\'' +
                ", sysParamType='" + sysParamType + '\'' +
                '}';
    }
}