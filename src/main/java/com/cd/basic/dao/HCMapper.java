package com.cd.basic.dao;

import com.cd.basic.pojo.init.SysUser;

import java.util.List;

/***
 * 缓存-mapper
 */
public interface HCMapper {

    //加载字典
    List<SysUser> selectSysUser();
}
