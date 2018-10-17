package com.cd.common.pojo.domain.vo;

import io.swagger.annotations.ApiModelProperty;

public class NewMessageForm {
    @ApiModelProperty(value = "接收消息的用户学校外键",dataType = "String",required = true)
    private String schoolFkCode;
    @ApiModelProperty(value = "接收消息的用户外键",dataType = "String",required = true)
    private String userFkCode;
    @ApiModelProperty(value = "接收消息的用户名称",dataType = "String",required = true)
    private String userName;
    @ApiModelProperty(value = "消息的标题",dataType = "String",required = true)
    private String messageTitle;
    @ApiModelProperty(value = "消息类别",dataType = "String",required = true)
    private String messageType;
    @ApiModelProperty(value = "消息类别名称",dataType = "String",required = true)
    private String messageTypeName;
    @ApiModelProperty(value = "消息参数（JSON形式）",dataType = "String",required = true)
    private String messageParams;

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

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageTypeName() {
        return messageTypeName;
    }

    public void setMessageTypeName(String messageTypeName) {
        this.messageTypeName = messageTypeName;
    }

    public String getMessageParams() {
        return messageParams;
    }

    public void setMessageParams(String messageParams) {
        this.messageParams = messageParams;
    }
}
