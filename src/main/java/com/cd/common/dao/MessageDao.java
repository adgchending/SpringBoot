package com.cd.common.dao;

import com.cd.common.pojo.domain.vo.NewMessageForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MessageDao {
    int createMessage(@Param("form") NewMessageForm form, @Param("fkCode") long fkCode);
}
