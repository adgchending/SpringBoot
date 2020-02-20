package com.cd.activiti.pojo;

import io.swagger.annotations.ApiModelProperty;

public class UpdateMoneyDto {
    @ApiModelProperty(value = "经办人所属校区", dataType = "String", required = true)
    private String agentCampusFkCode;//经办人所属校区(通过这个字段关联预算表里里校区)
    @ApiModelProperty(value = "项目分类(冗余字段)", dataType = "String", required = true)
    private String objectType;//项目名称(冗余字段)
    @ApiModelProperty(value = "项目名称(冗余字段)", dataType = "String", required = true)
    private String objectNameTo;//项目名称(冗余字段)
    @ApiModelProperty(value = "学校信息表(Basic_School_Infor)的外键标识", dataType = "String", required = true)
    private String schoolFkCode;//学校信息表(Basic_School_Infor)的外键标识
    @ApiModelProperty(value = "报销金额", dataType = "Double", required = true)
    private Double rbMoney;//报销金额

    public String getAgentCampusFkCode() {
        return agentCampusFkCode;
    }

    public void setAgentCampusFkCode(String agentCampusFkCode) {
        this.agentCampusFkCode = agentCampusFkCode;
    }

    public String getObjectNameTo() {
        return objectNameTo;
    }

    public void setObjectNameTo(String objectNameTo) {
        this.objectNameTo = objectNameTo;
    }

    public String getSchoolFkCode() {
        return schoolFkCode;
    }

    public void setSchoolFkCode(String schoolFkCode) {
        this.schoolFkCode = schoolFkCode;
    }

    public Double getRbMoney() {
        return rbMoney;
    }

    public void setRbMoney(Double rbMoney) {
        this.rbMoney = rbMoney;
    }


    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
