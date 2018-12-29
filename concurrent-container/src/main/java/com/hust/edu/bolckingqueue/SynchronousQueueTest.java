package com.hust.edu.bolckingqueue;

import java.util.concurrent.SynchronousQueue;

/**
 * locate com.hust.edu.bolckingqueue
 * Created by MasterTj on 2018/12/29.
 */
public class SynchronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> synchronousQueue=new SynchronousQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronousQueue.take();
                    Thread.sleep(1000);
                    synchronousQueue.take();
                    Thread.sleep(1000);
                    synchronousQueue.take();
                    Thread.sleep(1000);
                    synchronousQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        synchronousQueue.put(1);
        System.out.println("1");
        synchronousQueue.put(2);
        System.out.println("2");
        synchronousQueue.put(3);
        System.out.println("3");
        synchronousQueue.put(4);
        System.out.println("4");

    }
}
