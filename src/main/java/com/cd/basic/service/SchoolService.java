package com.cd.basic.service;

import com.cd.basic.pojo.bo.BasicSchoolInforBo;
import com.cd.basic.pojo.vo.SchoolVo;
import com.cd.basic.pojo.vo.StudentVo;

import java.util.ArrayList;

public interface SchoolService {
    BasicSchoolInforBo muchDataBases(SchoolVo vo);

    BasicSchoolInforBo dataSourse(SchoolVo vo);

    boolean insertList(ArrayList<StudentVo> studentVos);

    void insert(StudentVo studentVo);
}
