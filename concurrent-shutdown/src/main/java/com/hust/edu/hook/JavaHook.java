package com.hust.edu.hook;

/**
 * locate com.hust.edu.hook
 * Created by MasterTj on 2019/1/9.
 */
public class JavaHook {
    private static class JavaTask implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-----------JavaTask shutdown----------");
        }
    }

    public static void main(String[] args) {
        JavaTask javaTask=new JavaTask();
        Thread thread=new Thread(javaTask);
        thread.start();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-----------JavaHook finish----------");
            }
        }));
        System.out.println("JVM finsih....");
    }
}
