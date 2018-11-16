package com.cd.basic.api;

import com.cd.basic.pojo.domain.BasicSchoolInfor;
import com.cd.basic.pojo.vo.UserVo;
import com.cd.basic.service.BasicSchoolInforService;
import com.cd.common.util.Result;
import com.cd.common.util.ResultUtil;
import com.cd.shiro.pojo.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

@RestController
@RequestMapping("/basic")
@Api(tags = "学校信息", value = "学校信息API")
public class SchoolController {
    @Autowired
    BasicSchoolInforService service;

    @ApiOperation(value = "测试")
    @GetMapping("/ceshi")
    //新增一个请假单
    public Result addLeaveInfo(@RequestParam String id) {
        switch (id) {
            case "1":
                return ResultUtil.success("你好1");
            case "2":
                return ResultUtil.success("你好2");
            case "3":
                return ResultUtil.success("2018-11-1 23:00:00修改");
            default:
                break;
        }
        return null;
    }

    @ApiOperation(value = "根据学校id获取学校")
    @GetMapping("/selectSchool")
    public Result selectSchoolInfor(@ApiParam(value = "请假事由") @RequestParam String id) {
        BasicSchoolInfor basicSchoolInfor = service.selectBasicSchoolInforById(Long.valueOf(id));
        return ResultUtil.success(basicSchoolInfor);
    }


    /**
     * @Param:描述:key值里面的#号代表这是一个SpEL表达式，此表达式可以遍历方法的参数对象，具体语法可以参考Spring的相关文档手册。
     * @return：返回结果描述:
     * @Throws：返回异常结果:
     * @Author: chenshangxian
     * @Date: 2018-11-16 17:23
     */
    @ApiOperation(value = "加数据到redis")
    @PostMapping("/add")
    @Cacheable(value = "redis1", key = "#vo.id")
    public Result add(@RequestBody UserVo vo) {
        User user = new User();
        user.setUserId(Long.parseLong(vo.getId()));
        user.setUserName(vo.getName());
        user.setUserAge(Integer.parseInt(vo.getAge()));
        return ResultUtil.success(user);
    }

    @ApiOperation(value = "从redis删除数据")
    @PostMapping("/delete")
    @CacheEvict(value = "redis1", key = "#vo.id")
    public Result delete(@RequestBody UserVo vo) {
        String id = vo.getId();
        return ResultUtil.success(id);
    }

}
