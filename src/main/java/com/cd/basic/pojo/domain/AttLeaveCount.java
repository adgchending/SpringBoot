package com.cd.basic.pojo.domain;
public class AttLeaveCount {
    private Long id;//主键id
    private Long userFkCode;//用户外键（学生外键Basic_Student_Infor-老师外键Basic_Worker_Infor）
    private Double leaveTime;//请假时长以小时为单位
    private Integer leaveType;//请假类型 获取数据字典请假类型
    private Integer delStatus;//删除状态(0.未删除；1.删除)
    private String leaveDate;//请假月份
    private java.util.Date createTime;//创建时间
    private java.util.Date updateTime;//更新时间
    private Long singleFkCode;//请假单号
    private Long fkCode;//外键唯一标识
    public AttLeaveCount() {
        super();
    }
    public AttLeaveCount(Long id,Long userFkCode,Double leaveTime,Integer leaveType,Integer delStatus,String leaveDate,java.util.Date createTime,java.util.Date updateTime,Long singleFkCode,Long fkCode) {
        super();
        this.id = id;
        this.userFkCode = userFkCode;
        this.leaveTime = leaveTime;
        this.leaveType = leaveType;
        this.delStatus = delStatus;
        this.leaveDate = leaveDate;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.singleFkCode = singleFkCode;
        this.fkCode = fkCode;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserFkCode() {
        return this.userFkCode;
    }

    public void setUserFkCode(Long userFkCode) {
        this.userFkCode = userFkCode;
    }

    public Double getLeaveTime() {
        return this.leaveTime;
    }

    public void setLeaveTime(Double leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Integer getLeaveType() {
        return this.leaveType;
    }

    public void setLeaveType(Integer leaveType) {
        this.leaveType = leaveType;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public String getLeaveDate() {
        return this.leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
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

    public Long getSingleFkCode() {
        return this.singleFkCode;
    }

    public void setSingleFkCode(Long singleFkCode) {
        this.singleFkCode = singleFkCode;
    }

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

}
