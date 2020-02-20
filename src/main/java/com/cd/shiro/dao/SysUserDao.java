package com.cd.shiro.dao;

import com.cd.shiro.pojo.domain.SysUser;

public interface SysUserDao {
    SysUser findByUserName(String username);
}
