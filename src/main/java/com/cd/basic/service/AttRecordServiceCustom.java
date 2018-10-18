package com.cd.basic.service;

import com.cd.basic.pojo.vo.AttRecordForm;

import java.util.List;

public interface AttRecordServiceCustom {
    /**
     * @author: haocunxin
     * @description: //新增打卡
     */
    List<String> insertAttRecord(AttRecordForm form);

}
