package com.cd.shiro.dao;

import java.util.List;

public interface SysPermissionDao {
    List<String> selectPermissionByUserId(Long userId);
}
