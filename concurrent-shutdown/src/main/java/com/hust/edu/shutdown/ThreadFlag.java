package com.hust.edu.shutdown;

/**
 * locate com.hust.edu.shutdown
 * Created by MasterTj on 2019/1/9.
 */
public class ThreadFlag implements Runnable{
    private volatile boolean exit=false;

    @Override
    public void run() {
        while (!exit){
            ///do something
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-----------ThreadFlag shutdown----------");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadFlag threadFlag=new ThreadFlag();
        Thread thread=new Thread(threadFlag);
        thread.start();
        Thread.sleep(3000);
        threadFlag.exit=true;
        thread.join();
        System.out.println("Ïß³ÌÍË³ö");
    }
}
