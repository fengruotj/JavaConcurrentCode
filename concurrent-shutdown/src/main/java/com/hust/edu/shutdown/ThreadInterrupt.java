package com.hust.edu.shutdown;

/**
 * locate com.hust.edu.shutdown
 * Created by MasterTj on 2019/1/9.
 */
enum  FuntuionType{
    FunctionType1,
    FunctionType2,
}
public class ThreadInterrupt implements Runnable{
    private FuntuionType funtuionType;

    public ThreadInterrupt(FuntuionType funtuionType) {
        this.funtuionType = funtuionType;
    }

    @Override
    public void run() {
        switch (funtuionType){
            case FunctionType1:
                int i = 0;
                while (!Thread.interrupted()){
                    //do something
                    i++;
                }
                System.out.println("Thread.interrupted() shutdown");
                break;
            case FunctionType2:
                try {
                    Thread.sleep(50*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Sleep InterruptedException throws");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterrupt threadInterrupt=new ThreadInterrupt(FuntuionType.FunctionType2);
        Thread thread=new Thread(threadInterrupt);
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("线程已经退出");
    }
}
