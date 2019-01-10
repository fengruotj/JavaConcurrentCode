package com.hust.edu;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/10.
 */
public class TimingThreadpool extends ThreadPoolExecutor{
    private final ThreadLocal<Long> startTime =new ThreadLocal<>();
    private final Logger logger= Logger.getLogger("TimingThreadpool");
    private final AtomicLong numTasks=new AtomicLong();
    private final AtomicLong totalTime=new AtomicLong();

    public TimingThreadpool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        logger.fine((String.format("Thread %s: start %s ",t,r)));
        startTime.set(System.nanoTime());
        numTasks.incrementAndGet();
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endTime=System.nanoTime();
            long taskTime=endTime-startTime.get();
            long l = totalTime.addAndGet(taskTime);
            logger.fine((String.format("Thread %s end %s ,time =%dns",t,r,taskTime)));
        } finally {
            super.afterExecute(r, t);
        }
    }

    @Override
    protected void terminated() {
        try {
            logger.fine(String.format("Terminated: avg time =%dns",totalTime.get()/numTasks.get()));
        } finally {
            super.terminated();
        }
    }
}
