package chapter01;

/**
 * 并发和单线程执行测试
 * 
 * @author tengfei.fangtf
 * @version $Id: ConcurrencyTest.java, v 0.1 2014-7-18 下午10:03:31 tengfei.fangtf Exp $
 */
public class ConcurrencyTest {

    /** 执行次数 */
    private static final long count = 10000l;

    public static void main(String[] args) throws InterruptedException {
        //并发计算
        concurrency();
        //单线程计算
        serial();
    }

    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
                System.out.println(a);
            }
        });
        thread.start();
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        /**
         * join的意思是使得放弃当前线程的执行，并返回对应的线程，例如下面代码的意思就是：
         * 程序在main线程中调用thread线程的join方法，则main线程放弃cpu控制权，并返回thread线程继续执行直到线程thread执行完毕
         * 所以结果是thread线程执行完后，才到主线程执行，相当于在main线程中同步thread线程，thread执行完了，main线程才有执行的机会
         */
        thread.join();
        long time = System.currentTimeMillis() - start;
        System.out.println("concurrency :" + time + "ms,b=" + b);
    }

    private static void serial() {
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i = 0; i < count; i++) {
            a += 5;
        }
        int b = 0;
        for (long i = 0; i < count; i++) {
            b--;
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("serial:" + time + "ms,b=" + b + ",a=" + a);
    }

}
