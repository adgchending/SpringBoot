package com.cd.basic.api;

import com.cd.basic.service.BasicSchoolInforService;
import com.cd.common.util.Result;
import com.cd.common.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/act")
@Api(tags = "流程Demo", value = "流程接口")
public class SchoolController {
    @Autowired
    BasicSchoolInforService service;

    @ApiOperation(value = "一个测试")
    @GetMapping("/ceshi")
    //新增一个请假单
    public Result addLeaveInfo(@Param(value = "请假事由") @RequestParam String id) {
        switch (id) {
            case "1":
                return ResultUtil.success("你好1");
            case "2":
                return ResultUtil.success("你好2");
            case "3":
                return ResultUtil.success("你好3");
            case "4":
                return ResultUtil.success("你好4");
            case "5":
                return ResultUtil.success("你好999");

            default:
                break;
        }
        return null;
    }
}
