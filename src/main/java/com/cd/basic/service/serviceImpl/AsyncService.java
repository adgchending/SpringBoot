package com.cd.basic.service.serviceImpl;

import com.cd.basic.pojo.bo.StudentBo;
import com.cd.common.util.Thread.ITask;
import com.cd.common.util.Thread.MultiThreadUtils;
import com.cd.common.util.Thread.ResultBean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AsyncService implements ITask<ResultBean<String>, StudentBo> {
    @Override
    public ResultBean<String> execute(StudentBo integer, Map<String, Object> params) {
        /**
         * 具体业务逻辑：将list中的元素加上辅助参数中的数据返回
         */
        int addNum = Integer.valueOf(String.valueOf(params.get("addNum")));
        ResultBean<String> resultBean = ResultBean.newInstance();
        resultBean.setData(integer.toString());
        return resultBean;
    }

    @Async
    public void groupDataColloect(List<StudentBo> batchTcmList) throws SQLException {
        // 需要多线程处理的大量数据list
        // 创建多线程处理任务
        MultiThreadUtils<Integer> threadUtils = MultiThreadUtils.newInstance(8);
        ITask<ResultBean<String>, StudentBo> task = new AsyncService();
        // 辅助参数  加数
        Map<String, Object> params = new HashMap<>();
        params.put("addNum", 7);
        // 执行多线程处理，并返回处理结果
        ResultBean<List<ResultBean<String>>> resultBean = threadUtils.execute(batchTcmList, params, task);
    }
}
