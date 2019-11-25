package com.cd.common.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * @方法描述: 线程工具类
 * @创建日期: 2019/9/26
 * @author: csx
 */
public class ThreadUtil {
    /**
     * @Description: 获取一个线程池
     * @Author: sl
     * @Date: 2019-05-22 17:26
     */
    public static ThreadPoolExecutor getThreadPool(int corePoolSize){
        return new ThreadPoolExecutor(corePoolSize, //核心线程大小
                corePoolSize * 2, //最大线程大小
                20, //线程最大空闲时间,超过此空闲时间可以被收回
                TimeUnit.MILLISECONDS, //最大空闲时间的单位
                new LinkedBlockingQueue<Runnable>(corePoolSize)//用于保存执行任务的队列,可以选择其他不同的队列来做任务管理
        );
    }
}
