package com.hust.edu.cancel;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/9.
 */
public class PrimeProducer implements Runnable {
    private final BlockingQueue<BigInteger> bigIntegers;
    private Thread thread;

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public PrimeProducer(BlockingQueue<BigInteger> bigIntegers) {
        this.bigIntegers = bigIntegers;
    }

    private volatile BigInteger p = BigInteger.ONE;

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()){
                p = p.nextProbablePrime();
                bigIntegers.put(p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void cancel(){
        thread.interrupt();
    }

    public BlockingQueue<BigInteger> getBigIntegers() {
        return bigIntegers;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<BigInteger> bigIntegers=new LinkedBlockingQueue<>();
        PrimeProducer primeProducer=new PrimeProducer(bigIntegers);

        Thread thread=new Thread(primeProducer);
        primeProducer.setThread(thread);
        thread.start();

        Thread.sleep(1000);
        primeProducer.cancel();
        for (BigInteger bigInteger : primeProducer.getBigIntegers()) {
            System.out.println(bigInteger);
        }
    }
}
