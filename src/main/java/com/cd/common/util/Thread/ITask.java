package com.cd.common.util.Thread;

import com.cd.basic.pojo.bo.StudentBo;

import java.util.Map;

/**
 * @ClassName: ITask
 * @Descripttion: TODO
 * @Author: HuT
 * @Date: 2021/8/23 16:08
 * @Version: 1.0
 **/
public interface ITask<T, StudentBo> {

    /**
     * @auther: csx
     * @Description:
     * @date: 2021/9/2 9:49
     * 任务执行方法接口<BR>
     * 方法名：execute<BR>
     * @param e 传入对象
     * @param params 其他辅助参数
     * @return T<BR> 返回值类型
     */
    T execute(StudentBo e, Map<String, Object> params);
}