package com.cd.basic.api;

import com.cd.basic.pojo.bo.BasicSchoolInforBo;
import com.cd.basic.pojo.domain.BasicSchoolInfor;
import com.cd.basic.pojo.vo.SchoolVo;
import com.cd.basic.service.BasicSchoolInforService;
import com.cd.basic.service.SchoolService;
import com.cd.common.Assist;
import com.cd.common.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @类名:SchoolController
 * @类描述:
 * @创建日期: 2019/8/12
 * @修改记录:
 * <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * @author: csx
 */
@RestController
@RequestMapping("/school-info")
@Api(tags = "学校信息")
public class SchoolController {
    @Autowired
    BasicSchoolInforService service;
    @Autowired
    SchoolService schoolService;

    @ApiOperation(value = "根据学校id获取学校")
    @GetMapping(value = "/select-school-info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<BasicSchoolInfor> selectSchoolInfor(@ApiParam(value = "学校id", required = true) @RequestParam String id) {
        Assist assist = new Assist();
        assist.setRequires(Assist.andEq("DEL_STATUS",0));
        assist.setRequires(Assist.andEq("ID",id));
        //BasicSchoolInfor vo = service.selectBasicSchoolInforById(Long.valueOf(id));
        List<BasicSchoolInfor> basicSchoolInfors = service.selectBasicSchoolInfor(assist);
        if (basicSchoolInfors != null) {
            return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(basicSchoolInfors);
        } else {
            return ResultVo.getInstance(Boolean.FALSE, "查询无数据");
        }
    }

    @ApiOperation(value = "根据学校id获取学校(测试多数据源1)")
    @PostMapping(value = "/ceshi", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<BasicSchoolInforBo> muchDataBases(@RequestBody SchoolVo vo) {
        BasicSchoolInforBo basicSchoolInforBo = schoolService.muchDataBases(vo);
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(basicSchoolInforBo);
    }

    @ApiOperation(value = "根据学校id获取学校(测试多数据源2)")
    @PostMapping(value = "/dataSourse", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<BasicSchoolInforBo> dataSourse(@RequestBody SchoolVo vo) {
        BasicSchoolInforBo basicSchoolInforBo = schoolService.dataSourse(vo);
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(basicSchoolInforBo);
    }

}
