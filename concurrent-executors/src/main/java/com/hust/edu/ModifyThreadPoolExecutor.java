package com.hust.edu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/10.
 */
public class ModifyThreadPoolExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        if(executorService instanceof ThreadPoolExecutor){
            ((ThreadPoolExecutor)executorService).setCorePoolSize(10);
            ((ThreadPoolExecutor)executorService).setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        }
        else
            throw new AssertionError("Ops, bad assumption");
    }
}
