package com.cd.basic.service.serviceImpl;


import com.cd.basic.dao.HCMapper;
import com.cd.basic.pojo.init.SysUser;
import com.cd.common.init.CacheData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName:
 * @Descripttion: 初始化加载数据，存redis
 * @Author: csx
 * @Date: 2021/8/19 10:28
 * @Version: 1.0
 **/
@Component
public class DataInitService implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitService.class);

    @Resource
    private HCMapper hcMapper;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        long s_start = System.currentTimeMillis();
        log.info("====================开始加载缓存数据====================");

        //加载人员字典表
        initSystemDict();

        long s_end = System.currentTimeMillis();
        log.info("====================缓存数据加载完成，耗时["+((s_end - s_start)/1000)+"]秒====================");
    }

    public void initSystemDict(){
        log.info("====================加载sys_user(人员字典表)====================");
        long start = System.currentTimeMillis();

        //查询出数据库里的人员字典
        List<SysUser> sysUsers = hcMapper.selectSysUser();
//        Map<Integer,String> sysuerMap = new HashMap<>();
//
//        for (SysUser sysUser : sysUsers) {
//            sysuerMap.put(sysUser.getUser_id(),sysUser.getUser_name());
//        }
        //list转map
        Map<Integer, String> sysuerMap = sysUsers.stream().collect(Collectors.toMap(SysUser::getUser_id, SysUser::getUser_name, (key1, key2) -> key2));

        CacheData.sysuerMap = sysuerMap;
        long end = System.currentTimeMillis();
        log.info("====================加载sys_user(人员字典表)完成，数据量:["+sysUsers.size()+"]条，耗时["+((end-start)/1000)+"]秒====================");
    }
}
