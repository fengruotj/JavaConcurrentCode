package com.hust.edu;

import java.util.concurrent.*;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2018/12/29.
 */
public class ScheduleThreadExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledThreadPool=Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello i will be delay");
            }
        },1,2, TimeUnit.SECONDS);
        //scheduledThreadPool.shutdown();
        Future<Integer> submit = scheduledThreadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 6;
            }
        });

        Integer integer = submit.get();
        System.out.println(integer);
    }
}
