package com.cd.common.util.Thread;

import com.cd.basic.pojo.bo.StudentBo;
import com.cd.basic.service.serviceImpl.SchoolServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @ClassName: MultiThreadUtils
 * @Descripttion: TODO
 * @Author: csx
 * @Date: 2021/8/23 16:06
 * @Version: 1.0
 **/
public class MultiThreadUtils<T> {
    private static Logger logger = LoggerFactory.getLogger(MultiThreadUtils.class);

    // 线程个数，如不赋值，默认为5
    private int threadCount = 5;
    // 具体业务任务
    private ITask<ResultBean<String>, T> task;
    // 线程池管理器
    private CompletionService<ResultBean> pool = null;

    @Autowired
    private SchoolServiceImpl groupHttpClientServie;

    /**
     *
     * 初始化线程池和线程个数<BR>
     * 方法名：newInstance<BR>
     * @param threadCount
     * @return MultiThreadUtils<BR>
     * @exception <BR>
     * @since  2.0
     */
    public static MultiThreadUtils newInstance(int threadCount) {
        MultiThreadUtils instance = new MultiThreadUtils();
        threadCount = threadCount;
        instance.setThreadCount(threadCount);
        return instance;
    }

    /**
     *
     * 多线程分批执行list中的任务<BR>
     * 方法名：execute<BR>
     * @param data  线程处理的大数据量list
     * @param params    处理数据是辅助参数传递
     * @param task        具体执行业务的任务接口
     * @return ResultBean<BR>
     * @exception <BR>
     * @since  2.0
     */
    @SuppressWarnings("rawtypes")
    public ResultBean execute(List<StudentBo> data, Map<String, Object> params, ITask<ResultBean<String>, StudentBo> task) {
        // 创建线程池
        ExecutorService threadpool = Executors.newFixedThreadPool(threadCount);
        // 根据线程池初始化线程池管理器
        pool = new ExecutorCompletionService<ResultBean>(threadpool);
        // 开始时间（ms）
        long l = System.currentTimeMillis();
        // 数据量大小
        int length = data.size();
        // 每个线程处理的数据个数
        int taskCount = length / threadCount;
        // 划分每个线程调用的数据
        for (int i = 0; i < threadCount; i++) {
            // 每个线程任务数据list
            List<StudentBo> subData = null;
            if (i == (threadCount - 1)) {
                subData = data.subList(i * taskCount, length);
            } else {
                subData = data.subList(i * taskCount, (i + 1) * taskCount);
            }
            // 将数据分配给各个线程
            HandleCallable execute = new HandleCallable<T>(String.valueOf(i), subData, params, task);
            // 将线程加入到线程池
            pool.submit(execute);
        }

        // 总的返回结果集
        List<ResultBean<String>> result = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            // 每个线程处理结果集
            ResultBean<List<ResultBean<String>>> threadResult;
            try {
                threadResult = pool.take().get();
                result.addAll(threadResult.getData());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        // 关闭线程池
        threadpool.shutdownNow();
        // 执行结束时间
        long end_l = System.currentTimeMillis();
        logger.info("总耗时:{}ms", (end_l - l));
        return ResultBean.newInstance().setData(result);
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

}
