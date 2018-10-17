package com.cd.common.service;

import com.cd.basic.pojo.bo.PushBo;

import java.util.List;

public interface PushService {
    PushBo createPush(String title, String desc, String type, Object pushData);

    void send(String userFkCode,PushBo msgObj,Object params);

    void send(List<String> userFkCodes, PushBo msgObj, Object params);
}
