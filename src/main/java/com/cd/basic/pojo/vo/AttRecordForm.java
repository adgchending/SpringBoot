package com.cd.basic.pojo.vo;

import io.swagger.annotations.ApiModelProperty;

public class AttRecordForm {
    @ApiModelProperty(value = "卡号",dataType = "String",required = true)
    private String cardCode;
    @ApiModelProperty(value = "当前时间",dataType = "Long",required = true,example = "2018-09-04 09:22:06")
    private String time;//当前页
    @ApiModelProperty(value = "进出类型（1.进校；2.离校；3.通用）",dataType = "String",required = true)
    private String type;

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
