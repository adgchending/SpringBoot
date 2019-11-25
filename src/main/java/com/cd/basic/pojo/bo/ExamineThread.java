package com.cd.basic.pojo.bo;

import com.cd.common.util.SpringUtil;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class ExamineThread implements Callable<Object> {
    /***
     * 调用的server类
     */
    private Class service;

    /***
     * 对应的方法名称
     */
    private String methodName;

    /***
     * 传入的参数
     */
    private Object obj;

    /***
     * 线程数目
     */
    private CountDownLatch latch;

    public ExamineThread(Class service, String methodName, Object obj, CountDownLatch latch) {
        this.service = service;
        this.methodName = methodName;
        this.obj = obj;
        this.latch = latch;
    }

    @Override
    public Object call() {
        try {
            Object bean = SpringUtil.getBean(service);
            Class cls = obj.getClass();
            Method method = service.getDeclaredMethod(methodName, cls);
            return method.invoke(bean, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
        return null;
    }
}
