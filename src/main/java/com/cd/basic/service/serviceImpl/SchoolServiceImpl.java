package com.cd.basic.service.serviceImpl;

import com.cd.basic.dao.SchoolDao;
import com.cd.basic.pojo.bo.StudentBo;
import com.cd.basic.pojo.vo.StudentVo;
import com.cd.basic.service.SchoolService;
import com.cd.common.util.DateSourceUtil.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolDao schoolDao;

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
}
