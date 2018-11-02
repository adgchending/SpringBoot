package com.cd.sys_manage;

import com.cd.common.util.Result;
import com.cd.common.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys")
@Api(tags = "pc登录接口")
public class LoginC {

    @ApiOperation(value = "登录接口")
    @PostMapping("/login")
    public Result selectSchoolInfor() {


        return ResultUtil.success();
    }
}
