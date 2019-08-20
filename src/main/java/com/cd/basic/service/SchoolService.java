package com.cd.basic.service;

import com.cd.basic.pojo.bo.StudentBo;
import com.cd.basic.pojo.vo.StudentVo;

import java.util.ArrayList;
import java.util.List;

public interface SchoolService {
    int muchDataBases(List<StudentVo> vo);

    StudentBo dataSourse(String id);

    boolean insertList(ArrayList<StudentVo> studentVos);

    void insert(StudentVo studentVo);
}
