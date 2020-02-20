package com.cd.basic.dao;

import com.cd.basic.pojo.bo.BasicGetDicListBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BuildingDaoCustom {
    public List<BasicGetDicListBo> getDicList(@Param("schoolFkCode")Long schoolFkCode, @Param("dicCode")String dicCode);
}
