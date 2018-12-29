package com.hust.edu;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2018/12/29.
 */
public class ScheduleThreadExecutorTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool=Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello i will be delay");
            }
        },1,2, TimeUnit.SECONDS);
        //scheduledThreadPool.shutdown();
    }
}
