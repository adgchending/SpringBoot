package com.cd.basic.api;

import com.cd.basic.pojo.domain.BasicSchoolInfor;
import com.cd.basic.service.BasicSchoolInforService;
import com.cd.common.util.Result;
import com.cd.common.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
                return ResultUtil.success("2018-10-29日修改");
            default:
                break;
        }
        return null;
    }

    @ApiOperation(value = "根据学校id获取学校ini")
    @GetMapping("/basic")
    //新增一个请假单
    public Result selectSchoolInfor(@ApiParam(value = "请假事由") @RequestParam String id) {
        BasicSchoolInfor basicSchoolInfor = service.selectBasicSchoolInforById(Long.valueOf(id));
        return ResultUtil.success(basicSchoolInfor);
    }
}
