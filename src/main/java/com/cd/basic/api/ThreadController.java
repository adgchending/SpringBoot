package com.cd.basic.api;

import com.cd.basic.pojo.bo.StudentBo;
import com.cd.basic.service.SchoolService;
//import com.cd.basic.service.serviceImpl.AsyncService;
//import com.cd.basic.service.serviceImpl.ThreadServiceImpl;
import com.cd.basic.service.serviceImpl.AsyncService;
import com.cd.common.properties.WebConfig;
import com.cd.common.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/thread-info")
@Api(tags = "多线程测试")
public class ThreadController {
    @Autowired
    SchoolService schoolService;
    @Autowired
    AsyncService asyncService;

    /**
     * @方法描述: 多线程查询
     * @创建日期: 2019/9/26
     * @author: csx
     */
    @ApiOperation(value = "测试多线程查询,ps:数据量太大时swagger可能会卡住")
    @GetMapping(value = "/selectThread", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo selectThread(String id) {
        ResultVo vo = schoolService.selectThread(id);
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(vo);
    }

    /**
     * @方法描述: 新增大量数据, 可用于删除和修改
     * @创建日期: 2019/11/25
     * @author: csx
     */
    @ApiOperation(value = "新增大量数据(一次新增10w条数据,耗时13秒)")
    @GetMapping(value = "/insertTrade", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional(rollbackFor = Exception.class)
    public ResultVo insertTrade() {
        List<StudentBo> bos = new ArrayList<>();
        //新增10W条数据耗时13秒
        for (int i = 0; i < 100000; i++) {
            String name = "张三" + i;
            StudentBo studentBo = new StudentBo();
            studentBo.setName(name);
            studentBo.setAge(i);
            bos.add(studentBo);
        }
        long start = System.currentTimeMillis();
        //建立驱动
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //加载驱动建立连接
            conn = DriverManager.getConnection(WebConfig.url, WebConfig.username, WebConfig.password);
            conn.setAutoCommit(false);
            String sql = "insert into thread1 VALUES (?,?)";
            // 批量插入时ps对象必须放到for循环外面
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < bos.size(); i++) {
                ps.setString(1, bos.get(i).getName());
                ps.setInt(2, bos.get(i).getAge());

                ps.addBatch();
                if (i % 1000 == 0) {
                    ps.executeBatch();
                    conn.commit();
                    ps.clearBatch();
                }
            }
            // 剩余数量不足1000
            ps.executeBatch();
            conn.commit();
            ps.clearBatch();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("新增失败");
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(("耗时:" + (end - start) / 1000) + "秒");
    }

    /**
     * @方法描述: 多线程调用接口,
     * @创建日期: 2019/9/26
     * @author: csx
     */
    @ApiOperation(value = "for循环新增改多线程,应用于单独接口很慢的情况")
    @GetMapping(value = "/thread", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultVo thread() throws SQLException {
        //造数据
        List<StudentBo> bos = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            String name = "张三" + i;
            StudentBo studentBo = new StudentBo();
            studentBo.setName(name);
            studentBo.setAge(i);
            bos.add(studentBo);
        }
        long start = System.currentTimeMillis();
        //测试前先清空thread表
        schoolService.delete();
        try {
            //多线程新增thread表
            asyncService.groupDataColloect(bos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(("耗时:" + (end - start)/1000) + "秒");
        return ResultVo.getInstance(Boolean.TRUE, ResultVo.ReturnCode.SUCCESS).settingObjectData(("耗时:" + (end - start) / 1000) + "秒");
    }
}
