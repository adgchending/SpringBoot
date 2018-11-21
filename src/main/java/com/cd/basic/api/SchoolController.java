package com.cd.basic.api;

import com.cd.basic.pojo.domain.BasicSchoolInfor;
import com.cd.basic.service.BasicSchoolInforService;
import com.cd.common.util.Result;
import com.cd.common.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
@Api(tags = "学校信息")
public class SchoolController {
    @Autowired
    BasicSchoolInforService service;

    @ApiOperation(value = "测试swagger")
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

}
