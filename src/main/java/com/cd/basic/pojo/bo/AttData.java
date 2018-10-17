package com.cd.basic.pojo.bo;

public class AttData {
    //推送的信息外键
    private String processFkCode;
    //信息描述
    private String taskId;
    //推送类型
    private String time;

    public String getProcessFkCode() {
        return processFkCode;
    }

    public void setProcessFkCode(String processFkCode) {
        this.processFkCode = processFkCode;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
