package com.cd.common.util.Thread;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: AllBeanServiceUtil
 * @Descripttion: TODO
 * @Author: HuT
 * @Date: 2021/8/24 11:12
 * @Version: 1.0
 **/
@Configuration
public class AllBeanServiceUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AllBeanServiceUtil.context = applicationContext;
    }

    public static Object getBean(String className){
        if (context==null)
            return null;
        else
            return context.getBean(className);
    }
    public static <T> T getBean(Class<T> type) {
        return context.getBean(type);
    }
    public static ApplicationContext getApplicationContext(){
        return context;
    }
}
