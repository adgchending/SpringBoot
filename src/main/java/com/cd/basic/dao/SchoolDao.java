package com.cd.basic.dao;

import com.cd.basic.pojo.bo.BasicSchoolInforBo;
import com.cd.basic.pojo.vo.SchoolVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SchoolDao {
    BasicSchoolInforBo muchDataBases(SchoolVo vo);
}
