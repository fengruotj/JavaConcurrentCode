package com.hust.edu;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * locate com.hust.edu
 * Created by mastertj on 2018/12/29.
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask=new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 5;
            }
        });

        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}
