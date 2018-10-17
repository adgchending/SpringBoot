package com.cd.basic.pojo.domain;
public class AttRCardStudent {
    private Long id;//主键id
    private Long cardFkCode;//校卡外键(Att_Student_Card)的唯一主键标识
    private Integer delStatus;//删除状态(0:未删除；1：已删除)
    private java.util.Date updateTime;//更新时间
    private java.util.Date createTime;//创建时间
    private Long fkCode;//外键唯一标识
    private Long studentFkCode;//学生外键(Basic_Student_Infor)的唯一主键标识
    public AttRCardStudent() {
        super();
    }
    public AttRCardStudent(Long id,Long cardFkCode,Integer delStatus,java.util.Date updateTime,java.util.Date createTime,Long fkCode,Long studentFkCode) {
        super();
        this.id = id;
        this.cardFkCode = cardFkCode;
        this.delStatus = delStatus;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.fkCode = fkCode;
        this.studentFkCode = studentFkCode;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardFkCode() {
        return this.cardFkCode;
    }

    public void setCardFkCode(Long cardFkCode) {
        this.cardFkCode = cardFkCode;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public Long getFkCode() {
        return this.fkCode;
    }

    public void setFkCode(Long fkCode) {
        this.fkCode = fkCode;
    }

    public Long getStudentFkCode() {
        return this.studentFkCode;
    }

    public void setStudentFkCode(Long studentFkCode) {
        this.studentFkCode = studentFkCode;
    }

}
