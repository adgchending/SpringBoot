package com.cd.basic.pojo.domain;
public class AttSettingRestWorker {
    private Long id;//主键ID
    private Long settingFkCode;//考勤设置(Att_Setting_Worker)外键唯一标识
    private Integer delStatus;//删除状态 0:未删除；1：已删除
    private java.util.Date createTime;//创建时间
    private java.util.Date updateTime;//更新时间
    private java.util.Date restBigTime;//中间休息时间(开始)
    private java.util.Date restEndTime;//中间休息时间(结束)
    private Long fkCode;//外键唯一标识
    public AttSettingRestWorker() {
        super();
    }
    public AttSettingRestWorker(Long id,Long settingFkCode,Integer delStatus,java.util.Date createTime,java.util.Date updateTime,java.util.Date restBigTime,java.util.Date restEndTime,Long fkCode) {
        super();
        this.id = id;
        this.settingFkCode = settingFkCode;
        this.delStatus = delStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.restBigTime = restBigTime;
        this.restEndTime = restEndTime;
        this.fkCode = fkCode;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSettingFkCode() {
        return this.settingFkCode;
    }

    public void setSettingFkCode(Long settingFkCode) {
        this.settingFkCode = settingFkCode;
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

    public java.util.Date getRestBigTime() {
        return this.restBigTime;
    }

    public void setRestBigTime(java.util.Date restBigTime) {
        this.restBigTime = restBigTime;
    }

    public java.util.Date getRestEndTime() {
        return this.restEndTime;
    }

    public void setRestEndTime(java.util.Date restEndTime) {
        this.restEndTime = restEndTime;
    }

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

}
