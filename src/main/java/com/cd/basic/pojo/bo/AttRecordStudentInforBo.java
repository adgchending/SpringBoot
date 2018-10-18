package com.cd.basic.pojo.bo;

public class AttRecordStudentInforBo {
    private Long id;
    private String fkCode;    //外键
    private String studentFkcode;
    private String sudentName;
    private String campusFkcode;    //校区外键
    private String gradeName;
    private String classFkcode;
    private String type;
    private String attendanceStatus;
    private String attendanceDay;
    private String attendanceTime;
    private String createTime;//创建时间
    private String updateTime;//修改时间
    private String cardCode; //卡号
    private String schoolFkcode;   //学校外键
    private int delStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSudentName() {
        return sudentName;
    }

    public void setSudentName(String sudentName) {
        this.sudentName = sudentName;
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

    public String getStudentFkcode() {
        return studentFkcode;
    }

    public void setStudentFkcode(String studentFkcode) {
        this.studentFkcode = studentFkcode;
    }

    public String getCampusFkcode() {
        return campusFkcode;
    }

    public void setCampusFkcode(String campusFkcode) {
        this.campusFkcode = campusFkcode;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getClassFkcode() {
        return classFkcode;
    }

    public void setClassFkcode(String classFkcode) {
        this.classFkcode = classFkcode;
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

    public String getAttendanceDay() {
        return attendanceDay;
    }

    public void setAttendanceDay(String attendanceDay) {
        this.attendanceDay = attendanceDay;
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

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getSchoolFkcode() {
        return schoolFkcode;
    }

    public void setSchoolFkcode(String schoolFkcode) {
        this.schoolFkcode = schoolFkcode;
    }
}
