package com.cd.basic.pojo.domain;
public class AttTravelCount {
    private Long id;//主键id
    private Long userFkCode;//用户外键（学生外键Basic_Student_Infor-老师外键Basic_Worker_Infor）
    private Integer travelTime;//出差时长 天为单位
    private Integer delStatus;//删除状态(0.未删除；1.删除)
    private Integer travelType;//出差类型 (1市内，2省内，3国内，4国外)
    private java.util.Date createTime;//创建时间
    private java.util.Date updateTime;//更新时间
    private Long singleFkCode;//出差单号
    private String travelDate;//出差月份
    private Long fkCode;//外键唯一标识
    public AttTravelCount() {
        super();
    }
    public AttTravelCount(Long id,Long userFkCode,Integer travelTime,Integer delStatus,Integer travelType,java.util.Date createTime,java.util.Date updateTime,Long singleFkCode,String travelDate,Long fkCode) {
        super();
        this.id = id;
        this.userFkCode = userFkCode;
        this.travelTime = travelTime;
        this.delStatus = delStatus;
        this.travelType = travelType;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.singleFkCode = singleFkCode;
        this.travelDate = travelDate;
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

    public Integer getTravelTime() {
        return this.travelTime;
    }

    public void setTravelTime(Integer travelTime) {
        this.travelTime = travelTime;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public Integer getTravelType() {
        return this.travelType;
    }

    public void setTravelType(Integer travelType) {
        this.travelType = travelType;
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

    public String getTravelDate() {
        return this.travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

}
