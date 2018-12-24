package com.hust.edu.interrupt;

/**
 * locate com.hust.edu.interrupt
 * Created by MasterTj on 2018/12/24.
 */
public class InterruptSleep {
    static volatile boolean flag=true;

    static class SleepThread implements Runnable{
        @Override
        public void run() {
            while (flag)
            try {
                    Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag=false;
            }
        }
    }

    public static void main(String[] args) {
        Thread sleepThread=new Thread(new SleepThread(),"SleepThread");
        sleepThread.start();
        sleepThread.interrupt();
    }
}
