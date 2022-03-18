package com.cd.basic.service;

import com.cd.basic.pojo.bo.BasicSchoolInforBo;
import com.cd.basic.pojo.bo.StudentBo;
import com.cd.basic.pojo.vo.StudentVo;
import com.cd.common.vo.ResultVo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface SchoolService {
    int muchDataBases(List<StudentVo> vo);

    StudentBo dataSourse(String id);

    boolean insertList(ArrayList<StudentVo> studentVos);

    void insert(StudentVo studentVo);

    List<BasicSchoolInforBo> pageHelper();

    ResultVo selectThread(String id);

    void delete();
}
