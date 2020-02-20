package com.cd.basic.dao;

import com.cd.basic.pojo.bo.BasicSchoolInforBo;
import com.cd.basic.pojo.bo.StudentBo;
import com.cd.basic.pojo.vo.StudentVo;

import java.util.ArrayList;
import java.util.List;

public interface SchoolDao {
    int add(List<StudentVo> vo);

    StudentBo muchDataBases(String id);

    boolean insertList(ArrayList<StudentVo> studentVos);

    int insert(StudentVo studentVo);

    List<BasicSchoolInforBo> pageHelper();

    List<StudentBo> selectBasicWorkerInfor(String id);

    List<StudentBo> selectBasicSchoolInfor(String id);
}
