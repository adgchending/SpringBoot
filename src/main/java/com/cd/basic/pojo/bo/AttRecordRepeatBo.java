package com.cd.basic.pojo.bo;

public class AttRecordRepeatBo {
    private String day;
    private String startTime;
    private String endTime;
    private String type;
    private String personFkcode;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPersonFkcode() {
        return personFkcode;
    }

    public void setPersonFkcode(String personFkcode) {
        this.personFkcode = personFkcode;
    }
}
