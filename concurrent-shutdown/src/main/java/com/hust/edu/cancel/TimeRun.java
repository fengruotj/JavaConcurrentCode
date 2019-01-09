package com.hust.edu.cancel;

import java.util.concurrent.*;

/**
 * locate com.hust.edu.cancel
 * Created by MasterTj on 2019/1/9.
 */
public class TimeRun {
    private static ExecutorService executorService= Executors.newFixedThreadPool(5);

    public static void timeRun(Runnable runnable, long timeout, TimeUnit timeUnit){
        Future<?> submit = executorService.submit(runnable);
        try {
            submit.get(timeout,timeUnit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            //接下来任务将被取消
            e.printStackTrace();
        } finally {
            //如果任务已经结束，那么执行取消操作也不会带来任何影响
            //如果任务正在运行，那么将会被中断
            submit.cancel(true);
        }
    }
}
