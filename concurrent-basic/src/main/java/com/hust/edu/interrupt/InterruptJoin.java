package com.hust.edu.interrupt;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * locate com.hust.edu.interrupt
 * Created by MasterTj on 2018/12/24.
 */
public class InterruptJoin {

    static class WorkThread implements Runnable{

        private Thread thread;

        public WorkThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread() + " WorkThread start " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("join");
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " WorkThread end " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }

    static class JoinThread implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + " joinThread start " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("sleep");
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " joinThread end " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        }
    }

    public static void main(String[] args) {
        Thread joinThread=new Thread(new JoinThread(),"joinThread");
        Thread workThread=new Thread(new WorkThread(joinThread),"workThread");

        try {
            workThread.start();
            Thread.sleep(1000);
            joinThread.start();
            Thread.sleep(1000);
            workThread.interrupt();
            System.out.println("workThread interrupt");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
