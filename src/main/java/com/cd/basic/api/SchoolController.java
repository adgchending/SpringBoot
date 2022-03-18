package com.cd.basic.api;

import com.cd.basic.pojo.bo.BasicSchoolInforBo;
import com.cd.basic.pojo.bo.StudentBo;
import com.cd.basic.pojo.domain.BasicSchoolInfor;
import com.cd.basic.pojo.vo.StudentVo;
import com.cd.basic.service.BasicSchoolInforService;
import com.cd.basic.service.SchoolService;
import com.cd.basic.service.serviceImpl.DataInitService;
import com.cd.common.Assist;
import com.cd.common.init.CacheData;
import com.cd.common.properties.MyProperties;
import com.cd.common.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名:SchoolController
 * @类描述:
 * @创建日期: 2019/8/20
 * @修改记录: <pre>
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

    @Autowired
    DataInitService dataInitService;

    @Value("${myqueue}")
    private String myqueue;


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
    @ApiOperation(value = "新增学生信息(测试多数据源1)新增的是master主库")
    @PostMapping(value = "/ceshi", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo muchDataBases(@RequestBody List<StudentVo> vo) {
        Assist assist = new Assist();
        int i = schoolService.muchDataBases(vo);
        if (i > 0) {
            return ResultVo.getInstance(Boolean.TRUE, "新增成功");
        }
        return ResultVo.getInstance(Boolean.FALSE, "新增失败");
    }


    /**
     * 这里查询的是test从库,从库只能进行查询操作
     */
    @ApiOperation(value = "根据id查询学生信息(测试多数据源2)这里查询的是test从库,从库只能进行查询操作")
    @GetMapping(value = "/dataSourse", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo<StudentBo> dataSourse(@RequestParam String id) {
        StudentBo studentBo = schoolService.dataSourse(id);
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(studentBo);
    }

    @ApiOperation(value = "测试自定义properties文件")
    @GetMapping(value = "/properties", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo properties() {
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS)
                .settingObjectData("姓名: " + myProperties.getName() + " 年龄: " + myProperties.getAge() + "性别" + myProperties.getVo().getSex()
                        + "第二种方式,通过注解" + myqueue);
    }

    /**
     * @方法描述: 测试分页插件
     * @创建日期: 2019/9/26
     * @author: csx
     */
    @ApiOperation(value = "测试PageHelper分页插件")
    @GetMapping(value = "/pageHelper", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo pageHelper(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BasicSchoolInforBo> basicSchoolInforBo = schoolService.pageHelper();
        PageInfo<BasicSchoolInforBo> pageInfo = new PageInfo<>(basicSchoolInforBo);
        System.out.println("总数量：" + pageInfo.getTotal());
        System.out.println("当前页查询记录：" + pageInfo.getList().size());
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("每页显示数量：" + pageInfo.getPageSize());
        System.out.println("总页：" + pageInfo.getPages());
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(pageInfo);
    }

    /**
     * @方法描述: 从缓存里拿取数据
     * @创建日期: 2019/9/26
     * @author: csx
     */
    @ApiOperation(value = "从缓存里拿取数据")
    @GetMapping(value = "/getInit", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo getInit() throws Exception {
        //拿缓存的时候先刷新缓存,这样做可以保证缓存里的数据是最新的
        dataInitService.run(null);

        ArrayList<Object> objects = new ArrayList<>();

        int user_id = 1;
        for (int i = 0; i < 3; i++) {
            //根据id 拿姓名
            String user_name = CacheData.sysuerMap.get(user_id);
            System.out.println(user_name);
            objects.add(user_name);
            user_id++;
        }
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(objects);
    }
}
