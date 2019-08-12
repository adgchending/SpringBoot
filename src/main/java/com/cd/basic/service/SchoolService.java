package com.cd.basic.service;

import com.cd.basic.pojo.bo.BasicSchoolInforBo;
import com.cd.basic.pojo.vo.SchoolVo;

public interface SchoolService {
    BasicSchoolInforBo muchDataBases(SchoolVo vo);

    BasicSchoolInforBo dataSourse(SchoolVo vo);
}
