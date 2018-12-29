package com.hust.edu;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2018/12/29.
 */
public class RejectExecutionTest {
    public static void main(String[] args) {
        ThreadPoolExecutor abortPolicy=new ThreadPoolExecutor(5,10,20, TimeUnit.DAYS,new LinkedBlockingQueue<>(),new ThreadPoolExecutor.AbortPolicy());

        ThreadPoolExecutor callerRunsPolicy=new ThreadPoolExecutor(5,10,20, TimeUnit.DAYS,new LinkedBlockingQueue<>(),new ThreadPoolExecutor.CallerRunsPolicy());

        ThreadPoolExecutor discardOldestPolicy=new ThreadPoolExecutor(5,10,20, TimeUnit.DAYS,new LinkedBlockingQueue<>(),new ThreadPoolExecutor.DiscardOldestPolicy());

        ThreadPoolExecutor discardPolicy=new ThreadPoolExecutor(5,10,20, TimeUnit.DAYS,new LinkedBlockingQueue<>(),new ThreadPoolExecutor.DiscardPolicy());
    }
}
