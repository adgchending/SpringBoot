package com.cd.common.dao;

import com.cd.common.pojo.domain.PushUser;
import com.cd.common.pojo.domain.vo.RegisterPushForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PushUserCustomDao {
    PushUser selectPushUser(@Param("userFkCode")String userFkCode);

    void registerPushUser(@Param("form")RegisterPushForm form, @Param("fkCode")long fkCode);

    void updatePushUser(@Param("form")RegisterPushForm form);
}
