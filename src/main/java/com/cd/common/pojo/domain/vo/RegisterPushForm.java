package com.cd.common.pojo.domain.vo;

import io.swagger.annotations.ApiModelProperty;

public class RegisterPushForm {
    @ApiModelProperty(value = "用户所在组织（学校或教育局）的外键",dataType = "String",required = true)
    private String schoolFkCode;
    @ApiModelProperty(value = "用户唯一外键",dataType = "String",required = true)
    private String userFkCode;
    @ApiModelProperty(value = "用户名称",dataType = "String",required = true)
    private String userName;
    @ApiModelProperty(value = "注册推送服务的客户ID",dataType = "String",required = true)
    private String clientId;
    @ApiModelProperty(value = "设备类型",dataType = "String",required = true)
    private String facilityType;

    public String getSchoolFkCode() {
        return schoolFkCode;
    }

    public void setSchoolFkCode(String schoolFkCode) {
        this.schoolFkCode = schoolFkCode;
    }

    public String getUserFkCode() {
        return userFkCode;
    }

    public void setUserFkCode(String userFkCode) {
        this.userFkCode = userFkCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }
}
