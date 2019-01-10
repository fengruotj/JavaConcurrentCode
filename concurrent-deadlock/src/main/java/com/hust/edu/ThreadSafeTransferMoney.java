package com.hust.edu;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/10.
 */
public class ThreadSafeTransferMoney {
    public static final Object tileLock=new Object();

    public void transferMoney(Account fromAccount, Account toAccount){
        int fromHash=System.identityHashCode(fromAccount);
        int toHash=System.identityHashCode(toAccount);

        if(fromHash > toHash){
            synchronized (fromAccount){
                synchronized (toAccount){
                    //do transferMoney
                    System.out.println("--------transferMoney--------");
                }
            }
        }else if(fromHash < toHash){
            synchronized (fromAccount){
                synchronized (toAccount){
                    //do transferMoney
                    System.out.println("--------transferMoney--------");
                }
            }
        }else {
            synchronized (tileLock) {
                synchronized (fromAccount) {
                    synchronized (toAccount) {
                        //do transferMoney
                        System.out.println("--------transferMoney--------");
                    }
                }
            }
        }
    }
}
