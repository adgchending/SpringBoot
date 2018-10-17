package com.cd.basic.pojo.domain;
public class AttRecordWorker {
    private Long id;//主键ID
    private Long workerFkCode;//老师外键(Basic_Worker_Infor)的唯一外键标识
    private String cardCode;//卡号(Att_Worker_Card)唯一标识
    private Integer attendanceStatus;//考勤状态（1：正常，2：迟到，3:早退 4：未签到 5：未签退，6：在考勤设置之外打卡用 - 表示）
    private Integer delStatus;//删除状态 0:未删除；1：已删除
    private java.util.Date attendanceTime;//考勤时间
    private java.util.Date createTime;//创建时间
    private java.util.Date updateTime;//更新时间
    private java.util.Date attendanceDay;//考勤日期
    private Long fkCode;//外键唯一标识
    private Integer type;//进出类型（1：进校；2：离校；3：通用）
    private Long schoolFkCode;//学校外键(Basic_School_Infor)唯一外键标识
    public AttRecordWorker() {
        super();
    }
    public AttRecordWorker(Long id,Long workerFkCode,String cardCode,Integer attendanceStatus,Integer delStatus,java.util.Date attendanceTime,java.util.Date createTime,java.util.Date updateTime,java.util.Date attendanceDay,Long fkCode,Integer type,Long schoolFkCode) {
        super();
        this.id = id;
        this.workerFkCode = workerFkCode;
        this.cardCode = cardCode;
        this.attendanceStatus = attendanceStatus;
        this.delStatus = delStatus;
        this.attendanceTime = attendanceTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.attendanceDay = attendanceDay;
        this.fkCode = fkCode;
        this.type = type;
        this.schoolFkCode = schoolFkCode;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkerFkCode() {
        return this.workerFkCode;
    }

    public void setWorkerFkCode(Long workerFkCode) {
        this.workerFkCode = workerFkCode;
    }

    public String getCardCode() {
        return this.cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public Integer getAttendanceStatus() {
        return this.attendanceStatus;
    }

    public void setAttendanceStatus(Integer attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public java.util.Date getAttendanceTime() {
        return this.attendanceTime;
    }

    public void setAttendanceTime(java.util.Date attendanceTime) {
        this.attendanceTime = attendanceTime;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public java.util.Date getAttendanceDay() {
        return this.attendanceDay;
    }

    public void setAttendanceDay(java.util.Date attendanceDay) {
        this.attendanceDay = attendanceDay;
    }

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getSchoolFkCode() {
        return this.schoolFkCode;
    }

    public void setSchoolFkCode(Long schoolFkCode) {
        this.schoolFkCode = schoolFkCode;
    }

}
