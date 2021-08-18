package com.cd.basic.api;


import io.swagger.annotations.Api;
import org.pentaho.di.core.Const;
import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;

/**
 * @类名:KettleController
 * @类描述:java代码调用kettle水壶工具
 * @创建日期: 2021/4/14
 * @修改记录: <pre>
 *    修改日期：
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * @author: csx
 */
@RestController
@RequestMapping("/kettle")
@Api(tags = "Kettle")
public class KettleController {

    @RequestMapping("testKettle")
    public void testKettle() throws KettleException {
        //kettle的启动文件路径
        String jobPath = "E:\\workspace-资料文档\\DRGs事实表\\etl\\drgs_etl_start.kjb";
        //kettle的数据库连接文件路径
        String kettleJNDI = "E:\\workspace-资料文档\\DRGs事实表\\etl\\simple-jndi";
        try {
            Const.JNDI_DIRECTORY = kettleJNDI;
            //初始化
            KettleEnvironment.init();
            //加载路径信息
            JobMeta JobMeta = new JobMeta(jobPath, null);
            Job job = new Job(null, JobMeta);

            //传入参数,可传可不传
//            job.setVariable("startDate", startDate);
//            job.setVariable("endDate", endDate);
//            job.setVariable("startYear", startYear);
//            job.setVariable("endYear", endYear);

            //启动
            job.start();
            //等待运行完成
            job.waitUntilFinished();

        } catch (KettleException e) {
            e.printStackTrace();
        }

    }


}
