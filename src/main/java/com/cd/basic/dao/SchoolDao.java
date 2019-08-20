package com.cd.basic.dao;

import com.cd.basic.pojo.bo.BasicSchoolInforBo;
import com.cd.basic.pojo.vo.SchoolVo;
import com.cd.basic.pojo.vo.StudentVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface SchoolDao {
    BasicSchoolInforBo muchDataBases(SchoolVo vo);

    boolean insertList(ArrayList<StudentVo> studentVos);

    void insert(StudentVo studentVo);
}
