package com.hust.edu.bolckingqueue;

import java.util.concurrent.LinkedTransferQueue;

/**
 * locate com.hust.edu.bolckingqueue
 * Created by MasterTj on 2018/12/29.
 */
public class LinkedTransferQueueTest {
    public static void main(String[] args) {
        LinkedTransferQueue<Integer> queue=new LinkedTransferQueue<Integer>();

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
                    System.out.println("removeÔªËØ³É¹¦£º"+remove);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    boolean b = queue.tryTransfer(20);
                    System.out.println(b);

                    queue.transfer(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
