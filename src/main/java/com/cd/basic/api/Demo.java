//package com.cd.basic.api;
//
//import com.cd.basic.pojo.bo.ExamineThread;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.Future;
//import java.util.concurrent.ThreadPoolExecutor;
//
//public class Demo {
//    public static void main(String[] args) throws Exception {
//        try {
//
//            //根据查询时间 分段拆分成多个线程同时执行
//            int page = 1;
//            int threadCount = 0;
//            Long start = System.currentTimeMillis();
//            CountDownLatch latch = new CountDownLatch(5);
//            ThreadPoolExecutor executor = ThreadUtil.getThreadPool();
//            List<Future<Object>> futureList = new ArrayList<>();
//
//            threadCount++;
//            if (i != 1 && calendar.getTime().before(endTime)) {
//                calendar.add(Calendar.DATE, 1);
//            }
//            String s_start = DateHelper.formateDate(calendar.getTime(), "yyyy-MM-dd");
//            String s_end = "";
//            calendar.add(Calendar.DATE, page);
//            s_end = DateHelper.formateDate(endTime, "yyyy-MM-dd");
//            request = new BaSearchRequest();
//            request.setZkBeginDate(s_start);
//            request.setZkEndDate(s_end);
//            request.setStatus("1");
//            request.setSbFlag("1");
//            request.setUserInfo(WtxUserInfo.getSysUser());
//            ExamineThread thread = new ExamineThread(ConfirmeSerivce.class, "sureallup", request, latch);
//            Future<Object> future = executor.submit(thread);
//            futureList.add(future);
//            break;
//            latch.await(); //所有线程执行完之后再进行返回
//
//            Long end = System.currentTimeMillis();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception(e);
//        }
//
//    }
//}
