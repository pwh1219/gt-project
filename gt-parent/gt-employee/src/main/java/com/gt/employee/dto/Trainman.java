package com.gt.employee.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 列车员管理表
 * </p>
 *
 * @author 潘文豪
 * @since 2021-02-15
 */
public class Trainman extends Model<Trainman> {

    private static final long serialVersionUID = 1L;

    /**
     * id,自增
     */
    @TableId(value = "man_id", type = IdType.AUTO)
    private Integer manId;

    /**
     * 乘务员姓名
     */
    private String manName;

    /**
     * 乘务员工号（登录乘务员系统用）
     */
    private String manAccount;

    private String manPassword;

    /**
     * 部门类型，见系统参数
     */
    private String deptType;

    /**
     * 所属铁路局，见系统参数
     */
    private String railways;

    /**
     * 客运段
     */
    private String kyd;

    /**
     * 子公司，见系统参数
     */
    private String filiale;

    /**
     * 状态，1表示可用，2表示禁用
     */
    private String status;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 工作状态，1表示在职，0表示离职
     */
    private String workStation;

    /**
     * 所属职务
     */
    private String duty;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否锁定，1表示是，0表示否
     */
    private String isLock;

    /**
     * 地址
     */
    private String address;

    /**
     * 性别
     */
    private String sex;

    /**
     * 紧急联系人
     */
    private String linkman;

    /**
     * 紧急联系人号码
     */
    private String linkmanNum;

    /**
     * 照片
     */
    private String photo;

    /**
     * 支付二维码
     */
    private String payQrcode;

    /**
     * 关注二维码地址
     */
    private String atQrcode;

    /**
     * 入职时间
     */
    private LocalDateTime entryTime;

    /**
     * 离职时间
     */
    private LocalDateTime leaveTime;

    /**
     * 民族，见系统参数
     */
    private String nation;


    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public String getManName() {
        return manName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getManAccount() {
        return manAccount;
    }

    public void setManAccount(String manAccount) {
        this.manAccount = manAccount;
    }

    public String getManPassword() {
        return manPassword;
    }

    public void setManPassword(String manPassword) {
        this.manPassword = manPassword;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkStation() {
        return workStation;
    }

    public void setWorkStation(String workStation) {
        this.workStation = workStation;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIsLock() {
        return isLock;
    }

    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkmanNum() {
        return linkmanNum;
    }

    public void setLinkmanNum(String linkmanNum) {
        this.linkmanNum = linkmanNum;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPayQrcode() {
        return payQrcode;
    }

    public void setPayQrcode(String payQrcode) {
        this.payQrcode = payQrcode;
    }

    public String getAtQrcode() {
        return atQrcode;
    }

    public void setAtQrcode(String atQrcode) {
        this.atQrcode = atQrcode;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(LocalDateTime leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    protected Serializable pkVal() {
        return this.manId;
    }

    @Override
    public String toString() {
        return "Trainman{" +
        "manId=" + manId +
        ", manName=" + manName +
        ", manAccount=" + manAccount +
        ", manPassword=" + manPassword +
        ", deptType=" + deptType +
        ", railways=" + railways +
        ", kyd=" + kyd +
        ", filiale=" + filiale +
        ", status=" + status +
        ", idCard=" + idCard +
        ", phone=" + phone +
        ", workStation=" + workStation +
        ", duty=" + duty +
        ", remark=" + remark +
        ", isLock=" + isLock +
        ", address=" + address +
        ", sex=" + sex +
        ", linkman=" + linkman +
        ", linkmanNum=" + linkmanNum +
        ", photo=" + photo +
        ", payQrcode=" + payQrcode +
        ", atQrcode=" + atQrcode +
        ", entryTime=" + entryTime +
        ", leaveTime=" + leaveTime +
        ", nation=" + nation +
        "}";
    }
}
