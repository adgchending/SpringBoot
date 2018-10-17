package com.cd.basic.pojo.bo;

public class AttRecordWorkerInforBo {
    private Long id;
    private String workerFkcode;   //教职工外键
    private String schoolFkcode;   //学校外键
    private String campusFkcode;    //校区外键

    private String cardCode; //卡号
    private String attendanceDay; //考勤日期
    private String type; //进出类型
    private String attendanceStatus; //考勤状态
    private String attendanceTime;//考勤时间
    private String createTime;//创建时间
    private String updateTime;//修改时间
    private String fkCode;    //外键
    private int delStatus;   //学校外键

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(int delStatus) {
        this.delStatus = delStatus;
    }

    public String getFkCode() {
        return fkCode;
    }

    public void setFkCode(String fkCode) {
        this.fkCode = fkCode;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getAttendanceDay() {
        return attendanceDay;
    }

    public void setAttendanceDay(String attendanceDay) {
        this.attendanceDay = attendanceDay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(String attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCampusFkcode() {
        return campusFkcode;
    }

    public void setCampusFkcode(String campusFkcode) {
        this.campusFkcode = campusFkcode;
    }

    public String getWorkerFkcode() {
        return workerFkcode;
    }

    public void setWorkerFkcode(String workerFkcode) {
        this.workerFkcode = workerFkcode;
    }

    public String getSchoolFkcode() {
        return schoolFkcode;
    }

    public void setSchoolFkcode(String schoolFkcode) {
        this.schoolFkcode = schoolFkcode;
    }

}
