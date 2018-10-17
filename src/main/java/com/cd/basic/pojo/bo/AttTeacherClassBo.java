package com.cd.basic.pojo.bo;

public class AttTeacherClassBo {
    private String workerFkcode;//教师外键
    private String classFkcode; //教师所在班级外键

    public String getWorkerFkcode() {
        return workerFkcode;
    }

    public void setWorkerFkcode(String workerFkcode) {
        this.workerFkcode = workerFkcode;
    }

    public String getClassFkcode() {
        return classFkcode;
    }

    public void setClassFkcode(String classFkcode) {
        this.classFkcode = classFkcode;
    }
}
