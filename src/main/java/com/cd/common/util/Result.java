package com.cd.common.util;

import io.swagger.annotations.ApiModelProperty;
/**
* @Param:描述:API返回的结果封装类
* @return：返回结果描述:
* @Throws：返回异常结果:
* @Author: chenshangxian
* @Date: 2018-9-17 16:06
*/
public class Result {
    @ApiModelProperty(value = "响应码",example = "成功为OK，错误为ERROR",dataType = "String")
    private String code;//返回的代码，成功为"OK"，错误为"ERROR"
    @ApiModelProperty(value = "返回的信息",example = "错误情况下返回错误信息，成功时返回空字符串",dataType = "String")
    private String msg;//错误消息
    @ApiModelProperty(value = "返回的json格式数据,如果响应吗为ERROR时,该字段为空字符串",dataType = "String")
    private Object data;//成功情况下返回的数据

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
