package com.cd.basic.service.serviceImpl;

import com.cd.basic.dao.SchoolDao;
import com.cd.basic.pojo.bo.StudentBo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "ThreadServiceImpl")
public class ThreadServiceImpl {

    @Resource
    SchoolDao schoolDao;

    public void threadOne(StudentBo tcmIndex) {
        schoolDao.insertThread(tcmIndex);
    }
}
