package com.cd.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 接口公用返回值
 * @author  marsLV
 */
@ApiModel
public class ResultVo<T> {

    /**
     * 是否成功
     */
    @ApiModelProperty(value = "成功返回的状态,成功返回true,失败返回false",example = "true",dataType = "boolean",position = -3)
    private boolean success;

    /**
     *  返回的标识码
     */
    @ApiModelProperty(value = "系统自定义的返回状态码",example = "0001",dataType = "String",position = -2)
    private String code;

    /**
     * 返回的消息
     */
    @ApiModelProperty(value = "返回的消息",example = "查询成功但无记录!",dataType = "String",position = -1)
    private String msg;

    /**
     * 返回的数据
     */
    @ApiModelProperty(value = "返回的数据",position = 100)
    private T data;


    /**
     * 返回的状态码及提示信息
     */
    public enum  ReturnCode{

        SUCCESS("0000","查询成功"),
        NO_DATA("0001","查询成功但无记录"),
        FAIL("0002","查询失败"),
        SYSTEM_ERROR("9999","系统异常");

        private String code;
        private String msg;

        ReturnCode(String code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }


    /**
     * 无参构造器
     */
    private ResultVo() {

    }



    private ResultVo(boolean success, ReturnCode returnCode) {
        this.success = success;
        this.code=returnCode.getCode();
        this.msg=returnCode.getMsg();
    }


    public static <T> ResultVo<T> getInstance(boolean success, ReturnCode returnCode){
        return new ResultVo<>(success,returnCode);
    }


    public static ResultVo getInstance(){
        return new ResultVo();
    }

//
    public  ResultVo settingObjectData(T data){
        this.data=data;
        return this;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}