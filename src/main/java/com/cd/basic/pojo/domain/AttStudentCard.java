package com.cd.basic.pojo.domain;
public class AttStudentCard {
    private Long id;//主键id
    private Long campusFkCode;//校区外键(Basic_Campus)外键唯一标识
    private String cardCode;//卡号
    private Integer bindingStatus;//绑定状态(1:绑定；2：未绑定)
    private Integer delStatus;//删除状态：0.未删除；1.删除
    private Integer enableStatus;//校卡状态：1.启用；2：禁用
    private String remarks;//备注
    private java.util.Date createTime;//创建时间
    private java.util.Date updateTime;//更新时间
    private Long fkCode;//外键唯一标识
    private Long schoolFkCode;//学校外键 (Basic_School_Infor)唯一外键标识
    private Integer type;//校卡类型：1，考勤卡 2:借读卡
    public AttStudentCard() {
        super();
    }
    public AttStudentCard(Long id,Long campusFkCode,String cardCode,Integer bindingStatus,Integer delStatus,Integer enableStatus,String remarks,java.util.Date createTime,java.util.Date updateTime,Long fkCode,Long schoolFkCode,Integer type) {
        super();
        this.id = id;
        this.campusFkCode = campusFkCode;
        this.cardCode = cardCode;
        this.bindingStatus = bindingStatus;
        this.delStatus = delStatus;
        this.enableStatus = enableStatus;
        this.remarks = remarks;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.fkCode = fkCode;
        this.schoolFkCode = schoolFkCode;
        this.type = type;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCampusFkCode() {
        return this.campusFkCode;
    }

    public void setCampusFkCode(Long campusFkCode) {
        this.campusFkCode = campusFkCode;
    }

    public String getCardCode() {
        return this.cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public Integer getBindingStatus() {
        return this.bindingStatus;
    }

    public void setBindingStatus(Integer bindingStatus) {
        this.bindingStatus = bindingStatus;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public Integer getEnableStatus() {
        return this.enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

    public Long getSchoolFkCode() {
        return this.schoolFkCode;
    }

    public void setSchoolFkCode(Long schoolFkCode) {
        this.schoolFkCode = schoolFkCode;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
