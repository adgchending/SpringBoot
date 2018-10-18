package com.cd.basic.pojo.domain;
public class AttSettingWorker {
    private Long id;//主键ID
    private java.util.Date offWprkTime;//下班时间
    private Long campusFkCode;//校区外键(Basic_Campus)外键唯一标识
    private java.util.Date signBackEndTime;//签退结束时间
    private java.util.Date signEndTime;//签到结束时间
    private java.util.Date activeTime;//考勤设置生效时间
    private java.util.Date updateTime;//更新时间
    private String attendanceDay;//考勤日（字符串类型，根据用户勾选出勤日，以字符串隔开）
    private Long fkCode;//外键唯一标识
    private Long schoolFkCode;//学校外键 (Basic_School_Infor)唯一外键标识
    private java.util.Date toWorkTime;//上班时间
    private Integer initiateMode;//启用状态 0启用 1未启用
    private java.util.Date expireTime;//考勤设置到期时间
    private Integer delStatus;//删除状态 0:未删除(当前数据) 1:已删除(历史数据) 2:删除中
    private java.util.Date signInHoursOfDate;//签到标记时间(未签到用)
    private java.util.Date signOutHoursOfDate;//签退标记时间(未签退用)
    private java.util.Date signBigTime;//签到开始时间
    private java.util.Date createTime;//创建时间
    private java.util.Date signBackBigTime;//签退开始时间
    public AttSettingWorker() {
        super();
    }
    public AttSettingWorker(Long id,java.util.Date offWprkTime,Long campusFkCode,java.util.Date signBackEndTime,java.util.Date signEndTime,java.util.Date activeTime,java.util.Date updateTime,String attendanceDay,Long fkCode,Long schoolFkCode,java.util.Date toWorkTime,Integer initiateMode,java.util.Date expireTime,Integer delStatus,java.util.Date signInHoursOfDate,java.util.Date signOutHoursOfDate,java.util.Date signBigTime,java.util.Date createTime,java.util.Date signBackBigTime) {
        super();
        this.id = id;
        this.offWprkTime = offWprkTime;
        this.campusFkCode = campusFkCode;
        this.signBackEndTime = signBackEndTime;
        this.signEndTime = signEndTime;
        this.activeTime = activeTime;
        this.updateTime = updateTime;
        this.attendanceDay = attendanceDay;
        this.fkCode = fkCode;
        this.schoolFkCode = schoolFkCode;
        this.toWorkTime = toWorkTime;
        this.initiateMode = initiateMode;
        this.expireTime = expireTime;
        this.delStatus = delStatus;
        this.signInHoursOfDate = signInHoursOfDate;
        this.signOutHoursOfDate = signOutHoursOfDate;
        this.signBigTime = signBigTime;
        this.createTime = createTime;
        this.signBackBigTime = signBackBigTime;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getOffWprkTime() {
        return this.offWprkTime;
    }

    public void setOffWprkTime(java.util.Date offWprkTime) {
        this.offWprkTime = offWprkTime;
    }

    public Long getCampusFkCode() {
        return this.campusFkCode;
    }

    public void setCampusFkCode(Long campusFkCode) {
        this.campusFkCode = campusFkCode;
    }

    public java.util.Date getSignBackEndTime() {
        return this.signBackEndTime;
    }

    public void setSignBackEndTime(java.util.Date signBackEndTime) {
        this.signBackEndTime = signBackEndTime;
    }

    public java.util.Date getSignEndTime() {
        return this.signEndTime;
    }

    public void setSignEndTime(java.util.Date signEndTime) {
        this.signEndTime = signEndTime;
    }

    public java.util.Date getActiveTime() {
        return this.activeTime;
    }

    public void setActiveTime(java.util.Date activeTime) {
        this.activeTime = activeTime;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAttendanceDay() {
        return this.attendanceDay;
    }

    public void setAttendanceDay(String attendanceDay) {
        this.attendanceDay = attendanceDay;
    }

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

    public Long getSchoolFkCode() {
        return this.schoolFkCode;
    }

    public void setSchoolFkCode(Long schoolFkCode) {
        this.schoolFkCode = schoolFkCode;
    }

    public java.util.Date getToWorkTime() {
        return this.toWorkTime;
    }

    public void setToWorkTime(java.util.Date toWorkTime) {
        this.toWorkTime = toWorkTime;
    }

    public Integer getInitiateMode() {
        return this.initiateMode;
    }

    public void setInitiateMode(Integer initiateMode) {
        this.initiateMode = initiateMode;
    }

    public java.util.Date getExpireTime() {
        return this.expireTime;
    }

    public void setExpireTime(java.util.Date expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public java.util.Date getSignInHoursOfDate() {
        return this.signInHoursOfDate;
    }

    public void setSignInHoursOfDate(java.util.Date signInHoursOfDate) {
        this.signInHoursOfDate = signInHoursOfDate;
    }

    public java.util.Date getSignOutHoursOfDate() {
        return this.signOutHoursOfDate;
    }

    public void setSignOutHoursOfDate(java.util.Date signOutHoursOfDate) {
        this.signOutHoursOfDate = signOutHoursOfDate;
    }

    public java.util.Date getSignBigTime() {
        return this.signBigTime;
    }

    public void setSignBigTime(java.util.Date signBigTime) {
        this.signBigTime = signBigTime;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getSignBackBigTime() {
        return this.signBackBigTime;
    }

    public void setSignBackBigTime(java.util.Date signBackBigTime) {
        this.signBackBigTime = signBackBigTime;
    }

}
