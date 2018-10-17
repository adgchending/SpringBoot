package com.cd.basic.pojo.domain;
public class AttRecordStudent {
    private Long id;//主键ID
    private java.util.Date attenadnceTime;//考勤时间
    private String cardCode;//考勤卡号 (Att_Student_Card)唯一标识
    private Integer attendanceStatus;//考勤状态 （1：正常，2：迟到，3:早退 4：未签到 5：未签退，6：在考勤设置之外打卡用 - 表示）',
    private Integer delStatus;//删除状态 0:未删除；1：已删除
    private java.util.Date createTime;//创建时间
    private java.util.Date updateTime;//更新时间
    private java.util.Date attendanceDay;//考勤日期
    private Long fkCode;//外键唯一标识
    private Integer type;//进出类型（1.进校；2.离校；3.通用）
    private Long schoolFkCode;//学校外键(Basic_School_Infor)唯一外键标识
    private Long studentFkCode;//学生外键(Basic_Student_Infor)的唯一主键标识
    public AttRecordStudent() {
        super();
    }
    public AttRecordStudent(Long id,java.util.Date attenadnceTime,String cardCode,Integer attendanceStatus,Integer delStatus,java.util.Date createTime,java.util.Date updateTime,java.util.Date attendanceDay,Long fkCode,Integer type,Long schoolFkCode,Long studentFkCode) {
        super();
        this.id = id;
        this.attenadnceTime = attenadnceTime;
        this.cardCode = cardCode;
        this.attendanceStatus = attendanceStatus;
        this.delStatus = delStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.attendanceDay = attendanceDay;
        this.fkCode = fkCode;
        this.type = type;
        this.schoolFkCode = schoolFkCode;
        this.studentFkCode = studentFkCode;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.Date getAttenadnceTime() {
        return this.attenadnceTime;
    }

    public void setAttenadnceTime(java.util.Date attenadnceTime) {
        this.attenadnceTime = attenadnceTime;
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

    public Long getStudentFkCode() {
        return this.studentFkCode;
    }

    public void setStudentFkCode(Long studentFkCode) {
        this.studentFkCode = studentFkCode;
    }

}
