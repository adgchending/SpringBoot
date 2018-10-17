package com.cd.common.service.serviceImpl;

import com.cd.basic.pojo.bo.PushBo;
import com.cd.common.dao.MessageDao;
import com.cd.common.dao.PushUserCustomDao;
import com.cd.common.pojo.domain.PushUser;
import com.cd.common.pojo.domain.vo.NewMessageForm;
import com.cd.common.service.PushService;

import com.cd.common.util.SnowFlake;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Destination;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * ActiveMq消息推送服务类
 */
@Service("ActivePushService")
public class PushServiceImpl implements PushService {

//    private final Destination destination = new ActiveMQTopic("Eaglesoul/Push");
    private final String identity = "@ys100@";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private PushUserCustomDao pushUserCustomDao;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private String objToString(Object object) {
        String message = "";
        try {
            message = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return message;
    }

    /**
     * 创建新消息数据
     * @param schoolFkCode
     * @param userFkCode
     * @param bo
     * @param data
     * @return
     */
    private String createMessage(String schoolFkCode, String userFkCode, PushBo bo, Object data) {
        NewMessageForm form = new NewMessageForm();
        form.setMessageTitle(bo.getTitle());
        form.setMessageType(bo.getType());
        String params = objToString(data);
        form.setMessageParams(params);
        form.setSchoolFkCode(schoolFkCode);
        form.setUserFkCode(userFkCode);
        long fkCode = SnowFlake.getId();
        this.messageDao.createMessage(form,fkCode);
        return Long.toString(fkCode);
    }

    /**
     * 发送消息（字符串）
     * @param message
     */
    private void sendString(String schoolFkCode,String message) {
        String topicName = "Eaglesoul&" + schoolFkCode;
        Destination destination = new ActiveMQTopic(topicName);
        this.jmsMessagingTemplate.convertAndSend(destination,message);
    }

    /**
     * 进入发送
     * @Param user
     * @Param msgObj
     * @Param params
     */
    private void inSend(String userFkCode,PushBo msgObj,Object params) {
        PushUser user = this.pushUserCustomDao.selectPushUser(userFkCode);
        if(user != null) {
            String schoolFkCode = user.getSchoolFkCode();
            String fkCode = this.createMessage(schoolFkCode,userFkCode,msgObj,params);
            msgObj.setMessageFkCode(fkCode);
            String message = objToString(msgObj);
            this.sendString(schoolFkCode,user.getFacilityIdentity() + this.identity + message);
        }
    }

    /**
     * 创建PushBo,其中pushData是模块要推送至客户端的参数对象
     * @param title
     * @param desc
     * @param type
     * @param pushData
     * @return
     */
    @Override
    public PushBo createPush(String title, String desc, String type, Object pushData) {
        PushBo bo = new PushBo();
        bo.setTitle(title);
        bo.setDesc(desc);
        LocalDateTime time = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        bo.setCreateTime(time.format(f));
        bo.setType(type);
        bo.setPushData(objToString(pushData));
        return bo;
    }

    /**
     * 推送（对象）
     * @param userFkCode 用户外键
     * @param msgObj PushBo推送消息对象
     * @param params PushBo中PushData所传入的数据
     */
    @Override
    @Transactional
    public void send(String userFkCode, PushBo msgObj, Object params) {
        this.inSend(userFkCode,msgObj,params);
    }

    /**
     * 推送（对象）（批量）
     * @param userFkCodes 用户外键集合
     * @param msgObj PushBo推送消息对象
     * @param params PushBo中PushData所传入的数据
     */
    @Override
    public void send(List<String> userFkCodes, PushBo msgObj, Object params) {
        for(String userFkCode : userFkCodes) {
            this.send(userFkCode,msgObj,params);
        }
    }
}
