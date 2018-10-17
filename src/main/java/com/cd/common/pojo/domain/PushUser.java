package com.cd.common.pojo.domain;

import java.util.Date;

public class PushUser {
    private String fkCode;
    private Date createTime;
    private Date updateTime;
    private String schoolFkCode;
    private String userFkCode;
    private String userName;
    private String facilityType;
    private String facilityIdentity;

    public String getFkCode() {
        return fkCode;
    }

    public void setFkCode(String fkCode) {
        this.fkCode = fkCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSchoolFkCode() {
        return schoolFkCode;
    }

    public void setSchoolFkCode(String schoolFkCode) {
        this.schoolFkCode = schoolFkCode;
    }

    public String getUserFkCode() {
        return userFkCode;
    }

    public void setUserFkCode(String userFkCode) {
        this.userFkCode = userFkCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getFacilityIdentity() {
        return facilityIdentity;
    }

    public void setFacilityIdentity(String facilityIdentity) {
        this.facilityIdentity = facilityIdentity;
    }
}
