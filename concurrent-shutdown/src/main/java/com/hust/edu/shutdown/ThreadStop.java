package com.hust.edu.shutdown;

/**
 * locate com.hust.edu.shutdown
 * Created by MasterTj on 2019/1/9.
 */
public class ThreadStop implements Runnable {
    @Override
    public void run() {
        try {
            while (true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            System.out.println("-----------ThreadStop shutdown----------");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStop threadStop=new ThreadStop();
        Thread thread=new Thread(threadStop);
        thread.start();
        Thread.sleep(3000);
        thread.stop();
        System.out.println("Ïß³ÌÍË³ö");
    }
}
