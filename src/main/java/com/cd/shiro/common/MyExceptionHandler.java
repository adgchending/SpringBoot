package com.cd.shiro.common;

import groovy.util.logging.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class MyExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyExceptionHandler.class);

   /**
    * @方法描述: 捕获AuthorizationException全局异常
    * @创建日期: 2022/2/25
    * @author: csx
    */
    @ExceptionHandler
    @ResponseBody
    public String ErrorHandler(AuthorizationException e) {
        LOGGER.info("doGetAuthorizationInfo", e);
        return "没有通过权限验证！";
    }
}