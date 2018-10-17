package com.cd.basic.pojo.bo;

import java.util.Objects;

public class AttSettingRestWorkerBo {
    private String restBigTime;//中间休息时间(开始)
    private String restEndTime;//中间休息时间(结束)

    public String getRestBigTime() {
        return restBigTime;
    }

    public void setRestBigTime(String restBigTime) {
        this.restBigTime = restBigTime;
    }

    public String getRestEndTime() {
        return restEndTime;
    }

    public void setRestEndTime(String restEndTime) {
        this.restEndTime = restEndTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AttSettingRestWorkerBo that = (AttSettingRestWorkerBo) o;
        return Objects.equals(restBigTime, that.restBigTime) &&
                Objects.equals(restEndTime, that.restEndTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(restBigTime, restEndTime);
    }
}
