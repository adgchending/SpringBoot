package com.cd.basic.pojo.bo;

public class PushBo {
    //推送标题
    private String title;
    //推送描述
    private String desc;
    //推送时间
    private String createTime;
    //推送类型
    private String type;
    //新信息外键
    private String messageFkCode;
    //推送参数
    private String pushData;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessageFkCode() {
        return messageFkCode;
    }

    public void setMessageFkCode(String messageFkCode) {
        this.messageFkCode = messageFkCode;
    }

    public String getPushData() {
        return pushData;
    }

    public void setPushData(String pushData) {
        this.pushData = pushData;
    }
}
