package com.cd.basic.service.serviceImpl;

import com.cd.basic.dao.SchoolDao;
import com.cd.basic.pojo.bo.BasicSchoolInforBo;
import com.cd.basic.pojo.bo.ExamineThread;
import com.cd.basic.pojo.bo.StudentBo;
import com.cd.basic.pojo.vo.StudentVo;
import com.cd.basic.service.SchoolService;
import com.cd.common.util.DateSourceUtil.TargetDataSource;
import com.cd.common.util.ThreadUtil;
import com.cd.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

@Service(value = "SchoolServiceImpl")
public class SchoolServiceImpl implements SchoolService {
    @Resource
    SchoolDao schoolDao;

    @Autowired
    AsyncService asyncService;

    //多数据源注解,根据value值来选定不同的连接
    @TargetDataSource(value = "ds1")
    @Override
    public int muchDataBases(List<StudentVo> vo) {
        return schoolDao.add(vo);
    }

    @TargetDataSource(value = "ds2")
    @Override
    public StudentBo dataSourse(String id) {
        return schoolDao.muchDataBases(id);
    }

    @Override
    public boolean insertList(ArrayList<StudentVo> studentVos) {
        return schoolDao.insertList(studentVos);
    }

    @Override
    public void insert(StudentVo studentVo) {
        schoolDao.insert(studentVo);
    }

    @Override
    public List<BasicSchoolInforBo> pageHelper() {
        return schoolDao.pageHelper();
    }


    @Override
    public void delete() {
        schoolDao.delete();
    }

    @Override
    public ResultVo selectThread(String id) {
        /***
         * CountDownLatch 这个类使一个线程等待其他线程各自执行完毕后再执行。
         *
         * CountDownLatch有三个方法:
         * //1.调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
         * public void await() throws InterruptedException { };
         * //2.和await()类似，只不过等待一定的时间后count值还没变为0的话就会继续执行
         * public boolean await(long timeout, TimeUnit unit) throws InterruptedException { };
         * //3.将count值减1
         * public void countDown() { };
         */
        long start = System.currentTimeMillis();

        CountDownLatch latch = new CountDownLatch(2);

        //通过线程池获得2个线程
        ThreadPoolExecutor executor = ThreadUtil.getThreadPool(2);

        //同时查询学校信息,老师信息
        String[] methodArr = new String[]{"selectBasicSchoolInfor", "selectBasicWorkerInfor"};

        List<Object> list = new ArrayList<>();
        List<Future<Object>> futureList = new ArrayList<>();
        System.out.println();
        try {
            for (String method : methodArr) {
                ExamineThread thread = new ExamineThread(SchoolDao.class, method, id, latch);
                Future<Object> future = executor.submit(thread);
                futureList.add(future);
            }
            executor.shutdown(); //关闭线程池
            latch.await(); //所有线程执行完之后再进行返回
            //遍历所有结果
            for (Future<Object> future : futureList) {
                list.add(Arrays.asList(future.get()));
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        long end = System.currentTimeMillis();
        System.out.println(("耗时:" + (end - start)) + "毫秒");
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(list);
    }
}
