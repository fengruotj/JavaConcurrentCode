package com.hust.edu.bolckingqueue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * locate com.hust.edu.bolckingqueue
 * Created by MasterTj on 2018/12/29.
 */
public class LinkedBlockingDequeTest {
    public static void main(String[] args) {
        LinkedBlockingDeque<Integer> queue=new LinkedBlockingDeque<Integer>(5);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count=1;
                while (true){
                    try {
                        queue.putFirst(count++);
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
                        remove = queue.takeLast();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("remove元素成功："+remove);
                }
            }
        }).start();
    }
}
