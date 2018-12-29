package com.hust.edu.bolckingqueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * locate com.hust.edu.bolckingqueue
 * Created by MasterTj on 2018/12/29.
 */
public class LinkedblockingQueueTest {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue=new LinkedBlockingQueue<Integer>(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count=1;
                while (true){
                    try {
                        queue.put(count++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("添加元素成功："+count);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Integer remove = null;
                    try {
                        remove = queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("remove元素成功："+remove);
                }
            }
        }).start();
    }
}
