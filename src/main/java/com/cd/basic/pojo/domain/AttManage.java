package com.cd.basic.pojo.domain;
public class AttManage {
    private Long id;//主键ID
    private Long campusFkCode;//校区外键
    private java.util.Date enableTime;//启用时间
    private String remarks;//备注
    private Integer enable;//是否启用（1：启用；2：禁用）
    private java.util.Date updateTime;//更新时间
    private Long fkCode;//外键唯一标识
    private Long schoolFkCode;//学校外键 (Basic_School_Infor)唯一外键标识
    private String position;//安装位置
    private Integer status;//设备状态（1：在线；2：离线）
    private Integer delStatus;//删除状态：0.未删除；1.删除
    private Integer purpose;//用途：1.进校；2：离校；3：通用
    private java.util.Date disableTime;//禁用时间
    private java.util.Date createTime;//创建时间
    private Integer type;//设备类型；1：考勤机
    private String equipmentId;//设备id（打卡机传来为16进制，需要转成10进制存储）
    public AttManage() {
        super();
    }
    public AttManage(Long id,Long campusFkCode,java.util.Date enableTime,String remarks,Integer enable,java.util.Date updateTime,Long fkCode,Long schoolFkCode,String position,Integer status,Integer delStatus,Integer purpose,java.util.Date disableTime,java.util.Date createTime,Integer type,String equipmentId) {
        super();
        this.id = id;
        this.campusFkCode = campusFkCode;
        this.enableTime = enableTime;
        this.remarks = remarks;
        this.enable = enable;
        this.updateTime = updateTime;
        this.fkCode = fkCode;
        this.schoolFkCode = schoolFkCode;
        this.position = position;
        this.status = status;
        this.delStatus = delStatus;
        this.purpose = purpose;
        this.disableTime = disableTime;
        this.createTime = createTime;
        this.type = type;
        this.equipmentId = equipmentId;
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

    public java.util.Date getEnableTime() {
        return this.enableTime;
    }

    public void setEnableTime(java.util.Date enableTime) {
        this.enableTime = enableTime;
    }

    public String getRemarks() {
        return this.remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getEnable() {
        return this.enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
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

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public Integer getPurpose() {
        return this.purpose;
    }

    public void setPurpose(Integer purpose) {
        this.purpose = purpose;
    }

    public java.util.Date getDisableTime() {
        return this.disableTime;
    }

    public void setDisableTime(java.util.Date disableTime) {
        this.disableTime = disableTime;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEquipmentId() {
        return this.equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

}
