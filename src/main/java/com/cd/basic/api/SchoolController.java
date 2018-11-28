package com.cd.basic.api;

import com.cd.basic.pojo.domain.BasicSchoolInfor;
import com.cd.basic.service.BasicSchoolInforService;
import com.cd.common.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school-info")
@Api(tags = "学校信息")
public class SchoolController {
    @Autowired
    BasicSchoolInforService service;

    @ApiOperation(value = "根据学校id获取学校")
    @GetMapping(value = "/select-school-info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<BasicSchoolInfor> selectSchoolInfor(@ApiParam(value = "学校id", required = true)
                                                            @RequestParam String id) {
        BasicSchoolInfor vo = service.selectBasicSchoolInforById(Long.valueOf(id));
        if (vo != null) {
            return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(vo);
        } else {
            return ResultVo.getInstance(Boolean.FALSE, "查询无数据");
        }
    }
}
