package com.hust.edu;

import java.util.concurrent.*;

/**
 * locate com.hust.edu
 * Created by mastertj on 2018/12/29.
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<Integer> submit = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 5;
            }
        });
        Integer integer = submit.get();
        System.out.println(integer);
        executorService.shutdown();
    }
}
