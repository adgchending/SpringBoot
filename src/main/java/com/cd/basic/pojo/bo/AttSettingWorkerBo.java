package com.cd.basic.pojo.bo;

import java.util.List;

public class AttSettingWorkerBo {
    private String fkCode;//外键唯一标识
    private String schoolFkCode;//学校外键
    private String campusFkCode;//校区外键
    private String campusName;
    private String attendanceDay;//考勤日（字符串类型，根据用户勾选出勤日，以字符串隔开）
    private String toWorkTime;//上班时间
    private String offWprkTime;//下班时间
    private String signBigTime;//签到开始时间
    private String signEndTime;//签到结束时间
    private String signBackBigTime;//签退开始时间
    private String signBackEndTime;//签退结束时间
    private List<AttSettingRestWorkerBo> attSettingRestWorkerBoList;
    private Integer initiateMode;//启用状态 0启用 1不启用
    private Integer delStatus;//删除状态 0:未删除(当前数据)  2:删除中
    private String activeTime;//启用时间(考勤设置生效时间)
    private String expireTime;//到期时间(考勤设置到期时间)
    private String signInHoursOfDate;//签到标记时间(未签到用)
    private String signOutHoursOfDate;//签退标记时间(未签退用)

    public String getFkCode() {
        return fkCode;
    }

    public void setFkCode(String fkCode) {
        this.fkCode = fkCode;
    }

    public String getSchoolFkCode() {
        return schoolFkCode;
    }

    public void setSchoolFkCode(String schoolFkCode) {
        this.schoolFkCode = schoolFkCode;
    }

    public String getCampusFkCode() {
        return campusFkCode;
    }

    public void setCampusFkCode(String campusFkCode) {
        this.campusFkCode = campusFkCode;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getAttendanceDay() {
        return attendanceDay;
    }

    public void setAttendanceDay(String attendanceDay) {
        this.attendanceDay = attendanceDay;
    }

    public String getToWorkTime() {
        return toWorkTime;
    }

    public void setToWorkTime(String toWorkTime) {
        this.toWorkTime = toWorkTime;
    }

    public String getOffWprkTime() {
        return offWprkTime;
    }

    public void setOffWprkTime(String offWprkTime) {
        this.offWprkTime = offWprkTime;
    }

    public String getSignBigTime() {
        return signBigTime;
    }

    public void setSignBigTime(String signBigTime) {
        this.signBigTime = signBigTime;
    }

    public String getSignEndTime() {
        return signEndTime;
    }

    public void setSignEndTime(String signEndTime) {
        this.signEndTime = signEndTime;
    }

    public String getSignBackBigTime() {
        return signBackBigTime;
    }

    public void setSignBackBigTime(String signBackBigTime) {
        this.signBackBigTime = signBackBigTime;
    }

    public String getSignBackEndTime() {
        return signBackEndTime;
    }

    public void setSignBackEndTime(String signBackEndTime) {
        this.signBackEndTime = signBackEndTime;
    }

    public List<AttSettingRestWorkerBo> getAttSettingRestWorkerBoList() {
        return attSettingRestWorkerBoList;
    }

    public void setAttSettingRestWorkerBoList(List<AttSettingRestWorkerBo> attSettingRestWorkerBoList) {
        this.attSettingRestWorkerBoList = attSettingRestWorkerBoList;
    }

    public String getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }

    public Integer getInitiateMode() {
        return initiateMode;
    }

    public void setInitiateMode(Integer initiateMode) {
        this.initiateMode = initiateMode;
    }

    public Integer getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getSignInHoursOfDate() {
        return signInHoursOfDate;
    }

    public void setSignInHoursOfDate(String signInHoursOfDate) {
        this.signInHoursOfDate = signInHoursOfDate;
    }

    public String getSignOutHoursOfDate() {
        return signOutHoursOfDate;
    }

    public void setSignOutHoursOfDate(String signOutHoursOfDate) {
        this.signOutHoursOfDate = signOutHoursOfDate;
    }
}
