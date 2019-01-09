package com.hust.edu.cancel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * locate com.hust.edu.cancel
 * Created by MasterTj on 2019/1/9.
 */
public class PrimeGenerator implements Runnable{
    private final List<BigInteger> primes=new ArrayList<>();
    private volatile boolean cancelled = false;
    private volatile BigInteger p = BigInteger.ONE;
    @Override
    public void run() {

        while (!cancelled){
            //此方法返回一个整数大于该BigInteger的素数。
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel(){
        this.cancelled=true;
    }

    public synchronized List<BigInteger> get(){
        return new ArrayList<>(primes);
    }

    public static void main(String[] args) throws InterruptedException {
        PrimeGenerator primeGenerator=new PrimeGenerator();
        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(primeGenerator);
            thread.start();
        }

        Thread.sleep(2000);
        primeGenerator.cancel();
        for (BigInteger bigInteger : primeGenerator.get()) {
            System.out.println(bigInteger);
        }
    }
}
