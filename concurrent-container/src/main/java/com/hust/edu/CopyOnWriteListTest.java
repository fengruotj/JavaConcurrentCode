package com.hust.edu;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/7.
 */
public class CopyOnWriteListTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList=new CopyOnWriteArrayList<>();
        ExecutorService executorService= Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        copyOnWriteArrayList.add(j* finalI);
                    }
                }
            });
        }

        executorService.shutdown();
    }
}
