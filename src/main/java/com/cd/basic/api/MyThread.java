package com.cd.basic.api;

import java.util.concurrent.ThreadPoolExecutor;

public class MyThread implements Runnable {
    private int ticket = 500;


    @Override
    public void run() {
        for (int i=0; i<1000; i++) {
            if (this.ticket>0)
                System.out.println("线程开始："+Thread.currentThread().getName()+",卖票："+this.ticket--);
        }
    }



}
