package com.cd.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @DESC:
 * @Author: sl
 * @Date: 2019-05-22 17:25
 */
public class ThreadUtil {

    private static Logger logger = LoggerFactory.getLogger(ThreadUtil.class);

    private static ThreadPoolExecutor executor = null;

    //核心线程数
    private static Integer CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors();

    /**
     * @Description: 获取一个线程池
     * @Author: sl
     * @Date: 2019-05-22 17:26
     */
    public static ThreadPoolExecutor getThreadPool(){
        if (executor == null){
            executor = getThread(CORE_POOL_SIZE);
            logger.info("创建线程池成功！核心线程数为：" + CORE_POOL_SIZE + "个。");
        }
        return executor;
    }

    public static ThreadPoolExecutor getThread(int corePoolSize){
        return new ThreadPoolExecutor(corePoolSize, //核心线程大小
                corePoolSize, //最大线程大小
                60, //线程最大空闲时间,超过此空闲时间可以被收回
                TimeUnit.SECONDS, //最大空闲时间的单位
                new LinkedBlockingQueue<Runnable>(Integer.MAX_VALUE)//用于保存执行任务的队列,可以选择其他不同的队列来做任务管理
        );
    }
}
