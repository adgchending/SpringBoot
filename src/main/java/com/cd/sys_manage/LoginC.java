package com.cd.sys_manage;

import com.cd.common.util.Result;
import com.cd.common.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys")
@Api(tags = "pc登录接口")
public class LoginC {


    @ApiOperation(value = "登录接口")
    @GetMapping("/login")
    public Result selectSchoolInfor(@ApiParam(value = "请假事由") @RequestParam String id) {
        return ResultUtil.success();
    }
}
