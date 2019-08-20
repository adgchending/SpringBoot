package com.cd.basic.api;

import com.cd.basic.pojo.bo.StudentBo;
import com.cd.basic.pojo.domain.BasicSchoolInfor;
import com.cd.basic.pojo.vo.StudentVo;
import com.cd.basic.service.BasicSchoolInforService;
import com.cd.basic.service.SchoolService;
import com.cd.common.Assist;
import com.cd.common.properties.MyProperties;
import com.cd.common.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @类名:SchoolController
 * @类描述:
 * @创建日期: 2019/8/20
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
    @Autowired
    MyProperties myProperties;

    /** 
     * 通过Assist工具直接操作数据库,不用写业务代码
     */
    @ApiOperation(value = "根据学校id获取学校")
    @GetMapping(value = "/select-school-info", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<BasicSchoolInfor> selectSchoolInfor(@ApiParam(value = "学校id", required = true) @RequestParam String id) {
        Assist assist = new Assist();
        assist.setRequires(Assist.andEq("DEL_STATUS", 0));
        assist.setRequires(Assist.andEq("ID", id));
        //BasicSchoolInfor vo = service.selectBasicSchoolInforById(Long.valueOf(id));
        List<BasicSchoolInfor> basicSchoolInfors = service.selectBasicSchoolInfor(assist);
        if (basicSchoolInfors != null) {
            return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(basicSchoolInfors);
        } else {
            return ResultVo.getInstance(Boolean.FALSE, "查询无数据");
        }
    }

    /**
     * 新增的是master主库
     */
    @ApiOperation(value = "新增学生信息(测试多数据源1)")
    @PostMapping(value = "/ceshi", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo muchDataBases(@RequestBody List<StudentVo> vo) {
        int i = schoolService.muchDataBases(vo);
        if (i > 0) {
            return ResultVo.getInstance(Boolean.TRUE, "新增成功");
        }
        return ResultVo.getInstance(Boolean.FALSE, "新增失败");
    }


    /**
     * 这里查询的是test从库,从库只能进行查询操作
     */
    @ApiOperation(value = "根据id查询学生信息(测试多数据源2)")
    @GetMapping(value = "/dataSourse", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<StudentBo> dataSourse(@RequestParam String id) {
        StudentBo studentBo = schoolService.dataSourse(id);
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(studentBo);
    }

//    @ApiOperation(value = "mybatis批量存储数据")
//    @PostMapping(value = "/insertList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public boolean insertList() {
//        ArrayList<StudentVo> studentVos = new ArrayList<>();
//        for (int i = 0; i < 300000; i++) {
//            StudentVo studentVo = new StudentVo();
//            studentVo.setName("姓名" + i);
//            studentVo.setAge(i);
//            studentVos.add(studentVo);
//        }
//        Long startTime = System.currentTimeMillis();
//        boolean b = schoolService.insertList(studentVos);
//        Long endTime = System.currentTimeMillis();
//        System.out.println("用时：" + (endTime - startTime));
//        return b;
//    }
//
//    @ApiOperation(value = "普通批量存储数据")
//    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public void insert() {
//        ArrayList<StudentVo> studentVos = new ArrayList<>();
//        for (int i = 0; i < 300000; i++) {
//            StudentVo studentVo = new StudentVo();
//            studentVo.setName("姓名" + i);
//            studentVo.setAge(i);
//            studentVos.add(studentVo);
//        }
//        Long startTime = System.currentTimeMillis();
//        for (StudentVo studentVo : studentVos) {
//            schoolService.insert(studentVo);
//        }
//        Long endTime = System.currentTimeMillis();
//        System.out.println("用时：" + (endTime - startTime));
//    }

    @ApiOperation(value = "测试自定义properties")
    @GetMapping(value = "/properties", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo properties() {
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS)
                .settingObjectData("姓名: " + myProperties.getName() + " 年龄: " + myProperties.getAge() + "性别" + myProperties.getVo().getSex());
    }
}
