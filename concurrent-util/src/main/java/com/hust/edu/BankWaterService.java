package com.hust.edu;

import java.util.concurrent.*;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2018/12/29.
 * 银行处理服务类
 */
public class BankWaterService implements Runnable{
    private CyclicBarrier cyclicBarrier=new CyclicBarrier(4,this);

    private ExecutorService executor= Executors.newCachedThreadPool();

    private ConcurrentHashMap<String,Integer> sheetBankWaterCount=new ConcurrentHashMap<>();

    private void count(){
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    System.out.println("本次sheet运行结果："+1);
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
    @Override
    public void run() {
        int result=0;
        for (Integer integer : sheetBankWaterCount.values()) {
            result+=integer;
        }
        System.out.println("运行结果："+result);
    }

    public void stop(){
        executor.shutdown();
    }
    public static void main(String[] args) {
        BankWaterService bankWaterService=new BankWaterService();
        bankWaterService.count();
        bankWaterService.stop();
    }
}
