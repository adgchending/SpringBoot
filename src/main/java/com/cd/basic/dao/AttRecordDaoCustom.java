package com.cd.basic.dao;

import com.cd.basic.pojo.bo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AttRecordDaoCustom {
    /**
     * @author: haocunxin
     * @description: //获取教师卡号的相关信息
     */
    AttRecordWorkerInforBo getWorkerInfor(String cardCode);

    /**
     * @author: haocunxin
     * @description: //获取学生卡号的相关信息
     */
    AttRecordStudentInforBo getStudentInfor(String cardCode);

    /**
     * @author: haocunxin
     * @description: //获取教职工打卡设置信息
     */
    AttSettingWorkerBo getSttingWorkerInfor(@Param("campusFkcode") String campusFkcode, @Param("time") String time, @Param("week") Integer week);

    /**
     * @author: haocunxin
     * @description: //获取学生打卡设置信息
     */
    AttSettingWorkerBo getSttingStudentInfor(@Param("campusFkcode") String campusFkcode, @Param("time") String time, @Param("week") Integer week);

    /**
     * @author: haocunxin
     * @description: //是否教师
     */
    Integer workerType(String cardCode);

    /**
     * @author: haocunxin
     * @description: //是否学生
     */
    Integer studentType(String cardCode);

    /**
     * @author: haocunxin
     * @description: //教职工打卡记录新增
     */
    void insertRecordWork(AttRecordWorkerInforBo attRecordWorkerInforBo);

    /**
     * @author: haocunxin
     * @description: //教职工打卡记录新增
     */
    void insertRecordStudent(AttRecordStudentInforBo attRecordStudentInforBo);

    /**
     * @author: haocunxin
     * @description: //查询教师、学生打卡范围内有没有打卡
     */
    Integer getRecordWorkerRepeat(AttRecordRepeatBo form);

    /**
     * @author: haocunxin
     * @description: //查询教师、学生打卡范围内有没有打卡
     */
    Integer getRecordStudentRepeat(AttRecordRepeatBo form);

    /**
     * @author: haocunxin
     * @description: //教师打卡状态修改
     */
    void updateRecordWorker(AttRecordRepeatBo form);

    /**
     * @author: haocunxin
     * @description: //教师打卡状态修改
     */
    void updateRecordStudent(AttRecordRepeatBo form);

    /**
     * @author: haocunxin
     * @description: //通过学生外键查询班主任列表
     */
    List<AttTeacherClassBo> getHeadMasterListByStudentFkcode(String studentFkcode);

    /**
     * @author: haocunxin
     * @description: //查询班级学生外键列表
     */
    List<String> getAttClassStudent(String classFkcode);

    /**
     * @author: haocunxin
     * @description: //查询班级学生已打卡人数
     */
    Integer getCoutAttStudents(@Param("list") List<String> list, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("day") String day);

    List<String> getParentByStuFkcode(String stuFkCode);

}
