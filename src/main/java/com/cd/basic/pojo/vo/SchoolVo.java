package com.cd.basic.pojo.vo;

public class SchoolVo {
    private String type; //1为低风险,2为中风险
    private String startDate;//开始时间
    private String endDate;//结束时间

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
