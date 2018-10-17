package com.cd.basic.service.serviceImpl;

import com.cd.basic.dao.AttRecordDaoCustom;
import com.cd.basic.pojo.bo.*;
import com.cd.basic.pojo.vo.AttRecordForm;
import com.cd.basic.service.AttRecordServiceCustom;
import com.cd.common.service.PushService;
import com.cd.common.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

@Service
public class AttRecordServiceImplCustom implements AttRecordServiceCustom {
    @Autowired
    private AttRecordDaoCustom attRecordDaoCustom;
    @Autowired
    private PushService pushService;
    @Override
    /**
     * @author: haocunxin
     * @description: //考勤打卡
     * @Date: 2018-9-6 9:10
     * @param AttRecordForm
     */
    public List<String> insertAttRecord(AttRecordForm form) {
        //卡号：16进制转10进制
        String myCardCode = new BigInteger(form.getCardCode(), 16).toString();
        /*判断当前卡号是学生还是教师;type == 1是教师，type == 2是学生*/
        int type = 0;
        if(this.attRecordDaoCustom.workerType(myCardCode)>0){
            type =1;
        }else if(this.attRecordDaoCustom.studentType(myCardCode)>0){
            type =2;
        }
        /*教师*/
        String day = form.getTime().split(" ")[0];
        String time = form.getTime().split(" ")[1];
        String fkCode = String.valueOf(SnowFlake.getId());
        List<String> errorList = new ArrayList<>();
        if(type ==1){
            AttRecordWorkerInforBo workerInfor = this.attRecordDaoCustom.getWorkerInfor(myCardCode);
            AttRecordWorkerInforBo worker = new AttRecordWorkerInforBo();
            if(workerInfor!=null){
            worker.setFkCode(fkCode);
            worker.setWorkerFkcode(workerInfor.getWorkerFkcode());
            worker.setCardCode(workerInfor.getCardCode());
            worker.setAttendanceDay(day);
            worker.setType(form.getType());
            Map<String, String> parameter =getState(form.getType(),form.getTime(),type,workerInfor.getCampusFkcode(),workerInfor.getWorkerFkcode());
            worker.setAttendanceStatus(parameter.get("state"));
            worker.setAttendanceTime(time);
            worker.setCreateTime(form.getTime());
            worker.setUpdateTime(form.getTime());
            worker.setDelStatus(0);
            worker.setSchoolFkcode(workerInfor.getSchoolFkcode());
            this.attRecordDaoCustom.insertRecordWork(worker);
            /*不是无效打卡就推送*/
            if(!worker.getAttendanceStatus().equals("6")){
                /*上班*/
                String desc = "";
                if(parameter.get("type").equals("1")){
                    if(parameter.get("state").equals("1")){
                        desc = "正常签到,上班签到成功";
                    }else if (parameter.get("state").equals("2")){
                        desc = "迟到签到,上班签到成功";
                    }
                /*下班*/
                }else if(parameter.get("type").equals("2")){
                    if(parameter.get("state").equals("1")){
                        desc = "正常签到,下班签到成功";
                    }else if (parameter.get("state").equals("3")){
                        desc = "早退签到,下班签到成功";
                    }
                }
                try {
                    this.Attpush(workerInfor.getWorkerFkcode(), "考勤管理", desc, fkCode, time);
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            }else{
                errorList.add("卡号："+myCardCode+"的所属人不存在");
            }
        /*学生*/
        }else if(type ==2) {
            AttRecordStudentInforBo studentInfor = this.attRecordDaoCustom.getStudentInfor(myCardCode);
            AttRecordStudentInforBo student = new AttRecordStudentInforBo();

            if (studentInfor!=null){
            student.setFkCode(fkCode);
            student.setStudentFkcode(studentInfor.getStudentFkcode());
            student.setType(form.getType());
            Map<String, String> parameter = getState(form.getType(), form.getTime(), type, studentInfor.getCampusFkcode(), studentInfor.getStudentFkcode());
            student.setAttendanceStatus(parameter.get("state"));
            student.setAttendanceDay(day);
            student.setAttendanceTime(time);
            student.setCreateTime(form.getTime());
            student.setUpdateTime(form.getTime());
            student.setDelStatus(0);
            student.setCardCode(studentInfor.getCardCode());
            student.setSchoolFkcode(studentInfor.getSchoolFkcode());
            this.attRecordDaoCustom.insertRecordStudent(student);
            List<AttTeacherClassBo> teacherList = this.attRecordDaoCustom.getHeadMasterListByStudentFkcode(studentInfor.getStudentFkcode());
            List<String> parentsList = this.attRecordDaoCustom.getParentByStuFkcode(studentInfor.getStudentFkcode());
            /*学生迟到早退推送给班主任，正常无效不推送*/
            if (!student.getAttendanceStatus().equals("6") && !student.getAttendanceStatus().equals("1")) {
                List<String> List = new ArrayList<>();
                /*上班*/
                if (parameter.get("type").equals("1")) {
                    if (student.getAttendanceStatus().equals("2")) {
                        try {
                            /*剩余未打卡人数,可能一人多班级,要分别发送到个班级班主任，计算各班级剩余未打卡学生人数*/
                            if(teacherList.size() > 0) {
                                teacherList.forEach(e -> {
                                    List<String> calssStudents = this.attRecordDaoCustom.getAttClassStudent(e.getClassFkcode());
                                    int count = this.attRecordDaoCustom.getCoutAttStudents(calssStudents, parameter.get("startTime"), parameter.get("endTime"), day);
                                    int sum = calssStudents.size() - count;//未签到人数
                                    this.Attpush(e.getWorkerFkcode(), "考勤管理", studentInfor.getSudentName() + "迟到签单成功,剩余未签到" + sum + "人", fkCode, time);
                                });
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        try {
                            /*给家长推送*/
                            if(parentsList.size()>0){
                                this.AttParentpush(parentsList,"考勤管理","Hi，您的孩子已迟到。",studentInfor.getSudentName(),form.getTime(),"迟到");
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }


                    }
                } else if (parameter.get("type").equals("2")) {
                    if (student.getAttendanceStatus().equals("3")) {
                        try {
                            if (teacherList.size()>0) {
                                teacherList.forEach(e -> {
                                    List.add(e.getWorkerFkcode());
                                });
                                this.Attpush(List, "考勤管理", studentInfor.getSudentName() + "早退签到成功", fkCode, time);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            if(parentsList.size()>0){
                                this.AttParentpush(parentsList,"考勤管理","Hi，您的孩子已早退。",studentInfor.getSudentName(),form.getTime(),"早退");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }else {
                errorList.add("卡号："+myCardCode+"的所属人不存在");
            }
        }else{
            errorList.add("无效的卡号");
        }
        /*errorList.forEach(e->{
            System.out.println("error---------"+e);
        });*/

        return errorList;
    }

    /**
     * @author: haocunxin
     * @description: //考勤打卡状态判断
     * @Date: 2018-9-6 9:10
     * @param state 进出类型（1：进校；2：离校；3：通用）
     * @param dayTime 打卡时间yyyy-MM-dd HH:mm:ss
     * @param type 身份(1:教师;2:学生)
     * @param personFkcode 人员外键
     *
     */
    public Map<String, String> getState(String state,String dayTime,int type,String campusFkcode,String personFkcode){
        String day = dayTime.split(" ")[0];
        String time = dayTime.split(" ")[1];
        AttRecordRepeatBo repeat = new AttRecordRepeatBo();
        repeat.setDay(day);
        repeat.setPersonFkcode(personFkcode);
        repeat.setType(state);
        AttSettingWorkerBo setting = null;

        LocalDate today = LocalDate.now();
        //当前是星期几
        int dayofWeek = today.getDayOfWeek().getValue();
        if(type==1) {
            /*教师打卡时间段设置*/
            setting = attRecordDaoCustom.getSttingWorkerInfor(campusFkcode, time,dayofWeek);
        }else{
            setting = attRecordDaoCustom.getSttingStudentInfor(campusFkcode, time,dayofWeek);
        }
        Map<String, String> parameter = new HashMap<>();
        if(setting!=null){
            /*到校*/
            if(compTime(setting.getSignBigTime(),setting.getSignEndTime(),time)){
                parameter.put("startTime",setting.getSignBigTime());
                parameter.put("endTime",setting.getSignEndTime());
                parameter.put("type","1");/*1:上班，2：下班，3：通用（sql判断了）*/
                /*到校时间小于上班时间*/
                if(state.equals("1") || state.equals("3")) {
                    repeat.setStartTime(setting.getSignBigTime());
                    repeat.setEndTime(setting.getSignEndTime());
                    /*是否有打卡*/
                    if (type == 1 ? this.attRecordDaoCustom.getRecordWorkerRepeat(repeat) > 0 : this.attRecordDaoCustom.getRecordStudentRepeat(repeat) > 0) {
                        parameter.put("state","6");
                    } else {
                        if(compTime(setting.getToWorkTime(),time)){
                            parameter.put("state","1");
                        }else{
                            parameter.put("state","2");
                        }
                    }
                }else{
                    parameter.put("state","6");
                }

             /*离校*/
            }else if(compTime(setting.getSignBackBigTime(),setting.getSignBackEndTime(),time)){
                parameter.put("startTime",setting.getSignBackBigTime());
                parameter.put("endTime",setting.getSignBackEndTime());
                parameter.put("type","2");/*1:上班，2：下班，3：通用（sql判断了）*/
                if(state.equals("2") || state.equals("3")) {
                    repeat.setStartTime(setting.getSignBackBigTime());
                    repeat.setEndTime(setting.getSignBackEndTime());
                    /*是否有打卡*/
                    if (type == 1 ? this.attRecordDaoCustom.getRecordWorkerRepeat(repeat) > 0 : this.attRecordDaoCustom.getRecordStudentRepeat(repeat) > 0) {
                        repeat.setState("6");//把之前的记录状态改为6
                        repeat.setType("2");//数据库已判断了3的情况，这强制把所有情况改为2
                        if (type == 1) {
                            this.attRecordDaoCustom.updateRecordWorker(repeat);
                        } else {
                            this.attRecordDaoCustom.updateRecordStudent(repeat);
                        }

                    }
                    /*离校时间大于上班时间*/
                    if(compTime(time,setting.getOffWprkTime())){
                        parameter.put("state","1");
                    }else{
                        parameter.put("state","3");
                    }
                }else {
                    parameter.put("state","6");
                }

            }
        }else {
            /*不在时间范围内，或不属于打卡日*/
            parameter.put("state","6");
        }
        return  parameter;
    }

    /**
     * @author: haocunxin
     * @description: //是否在时间段,暂不用Date的after()与before()
     * @Date: 2018-9-6 9:10
     * @param startTime 开始节点时间 HH:mm:ss
     * @param endTime 结束节点时间 HH:mm:ss
     * @param time 对比时间 HH:mm:ss
     *
     */
    public static boolean compTime(String startTime,String endTime ,String time ){
        try {
            if (startTime.indexOf(":")<0||endTime.indexOf(":")<0||time.indexOf(":")<0) {
                System.out.println("格式不正确");
            }else{
                String[]array1 = startTime.split(":");
                int total1 = Integer.valueOf(array1[0])*3600+Integer.valueOf(array1[1])*60+Integer.valueOf(array1[2]);
                String[]array2 = endTime.split(":");
                int total2 = Integer.valueOf(array2[0])*3600+Integer.valueOf(array2[1])*60+Integer.valueOf(array2[2]);
                String[]array3 = time.split(":");
                int total3 = Integer.valueOf(array3[0])*3600+Integer.valueOf(array3[1])*60+Integer.valueOf(array3[2]);
                return (total3>=total1 && total2>=total3)?true:false;
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            return true;
        }
        return false;
    }

    /**
     * @author: haocunxin
     * @description: //时间大小比较,暂不用Date的after()与before()
     * @Date: 2018-9-6 9:10
     * @param time1 开始节点时间 HH:mm:ss
     * @param time2 结束节点时间 HH:mm:ss
     *
     */
    public static boolean compTime(String time1,String time2 ){
        try {
            if (time1.indexOf(":")<0||time2.indexOf(":")<0) {
                System.out.println("格式不正确");
            }else{
                String[]array1 = time1.split(":");
                int totaltime1 = Integer.valueOf(array1[0])*3600+Integer.valueOf(array1[1])*60+Integer.valueOf(array1[2]);
                String[]array2 = time2.split(":");
                int totaltime2 = Integer.valueOf(array2[0])*3600+Integer.valueOf(array2[1])*60+Integer.valueOf(array2[2]);
                return totaltime1-totaltime2>=0?true:false;

            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            return true;
        }
        return false;
    }

    /**
     * @author: haocunxin
     * @description: //教职工考勤推送
     * @Date: 2018-9-7 9:10
     * @param personid 教师外键
     * @param title 推送标题
     * @param desc 推送内容
     * @param time 打卡时间
     */
    public void Attpush(String personid,String title,String desc,String fkCode,String time){
        AttData data = new AttData();
        data.setProcessFkCode(fkCode);
        data.setTime(time);
        PushBo bo = pushService.createPush(title,desc,"KQGL",data);
        pushService.send(personid,bo,data);
    }
    /**
     * @author: haocunxin
     * @description: //学生考勤推送
     * @Date: 2018-9-7 9:10
     * @param personid 班主任教师外键list
     * @param title 推送标题
     * @param desc 推送内容
     * @param time 打卡时间
     */
    public void Attpush(List<String> personid,String title,String desc,String fkCode,String time){
        AttData data = new AttData();
        data.setProcessFkCode(fkCode);
        data.setTime(time);
        PushBo bo = pushService.createPush(title,desc,"KQGL",data);
        pushService.send(personid,bo,data);
    }

    /**
     * @author: haocunxin
     * @description: //学生考勤推送
     * @Date: 2018-9-7 9:10
     * @param parentFkCode 家长外键list
     * @param title 推送标题
     * @param desc 推送内容
     * @param studentName 学生名称
     * @param time 打卡时间
     * @param state 状态
     */
    public void AttParentpush(List<String> parentFkCode,String title,String desc,String studentName,String time,String state){
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        AttParentPush data = new AttParentPush();
        data.setDayTime(month+"月"+day+"日");
        data.setDesc(desc);
        data.setStudentName(studentName);
        data.setAttTime(time);
        data.setState(state);
        PushBo bo = pushService.createPush(title,desc,"KQGL",data);
        pushService.send(parentFkCode,bo,data);
    }
}
