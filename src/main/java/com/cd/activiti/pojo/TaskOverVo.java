package com.cd.activiti.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class TaskOverVo {
    @ApiModelProperty(value = "业务单据id(不是请假单外键,由查询代办接口查出来)", dataType = "String", required = true)
    private String taskId;
    @ApiModelProperty(value = "审批人外键(登录获得)", dataType = "String", required = true)
    private String userFkCode;
    @ApiModelProperty(value = "是否通过,通过传pass,不通过传reject,知会传known", dataType = "String", required = true)
    private String aduit;
    @ApiModelProperty(value = "请假天数(只有请假和出差有,其余的申请单此字段为空)", dataType = "String", required = false)
    private String day;
    @ApiModelProperty(value = "审批人名字", dataType = "String", required = false)
    private String userName;
    @ApiModelProperty(value = "审批意见(知会情况此字段为空)", dataType = "String", required = false)
    private String opinion;//审批意见
    @ApiModelProperty(value = "业务单据外键(ps:请假单外键)", dataType = "String", required = false)
    private String processFkCode;//业务单据外键
    @ApiModelProperty(value = "流程单的别名(报销专用,如果是报销单审批传BX2)", dataType = "String", required = false)
    private String processType;//流程单的别名(用于改变当前流程状态)
    @ApiModelProperty(value = "报销外键和报销金额 报销不通过情况下 还钱给预算表", dataType = "String", required = false)
    private List<UpdateMoneyDto> list;//

    public List<UpdateMoneyDto> getList() {
        return list;
    }

    public void setList(List<UpdateMoneyDto> list) {
        this.list = list;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProcessFkCode() {
        return processFkCode;
    }

    public void setProcessFkCode(String processFkCode) {
        this.processFkCode = processFkCode;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUserFkCode() {
        return userFkCode;
    }

    public void setUserFkCode(String userFkCode) {
        this.userFkCode = userFkCode;
    }

    public String getAduit() {
        return aduit;
    }

    public void setAduit(String aduit) {
        this.aduit = aduit;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
