package com.cd.basic.dao;

import com.cd.basic.pojo.bo.StudentBo;
import com.cd.basic.pojo.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface SchoolDao {
    int add(List<StudentVo> vo);

    StudentBo muchDataBases(String id);

    boolean insertList(ArrayList<StudentVo> studentVos);

    int insert(StudentVo studentVo);


}
