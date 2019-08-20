package com.cd.basic.service.serviceImpl;

import com.cd.basic.dao.SchoolDao;
import com.cd.basic.pojo.bo.BasicSchoolInforBo;
import com.cd.basic.pojo.vo.SchoolVo;
import com.cd.basic.pojo.vo.StudentVo;
import com.cd.basic.service.SchoolService;
import com.cd.common.util.DateSourceUtil.TargetDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolDao schoolDao;


    @TargetDataSource(value = "ds1")
    @Override
    public BasicSchoolInforBo muchDataBases(SchoolVo vo) {
        return schoolDao.muchDataBases(vo);
    }

    @TargetDataSource(value = "ds2")
    @Override
    public BasicSchoolInforBo dataSourse(SchoolVo vo) {
        return schoolDao.muchDataBases(vo);
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
