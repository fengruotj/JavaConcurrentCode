package com.hust.edu;

import java.util.concurrent.CountDownLatch;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/10.
 */
public class LeftRightDeadLock {
    private final Object left=new Object();
    private final Object right=new Object();

    private CountDownLatch countDownLatch=new CountDownLatch(1);

    public void leftRight(){
        try {
            countDownLatch.await();
            synchronized (left){
                Thread.sleep(1000);
                synchronized (right){
                    System.out.println("-------leftRight---------");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void rightLeft(){
        try {
            countDownLatch.await();
            synchronized (right){
                Thread.sleep(1000);
                synchronized (left){
                    System.out.println("-------Rightleft---------");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void countDown(){
        countDownLatch.countDown();
    }

    public static void main(String[] args) {
        LeftRightDeadLock leftRightDeadLock=new LeftRightDeadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                leftRightDeadLock.leftRight();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                leftRightDeadLock.rightLeft();
            }
        }).start();

        leftRightDeadLock.countDown();
    }
}
