package com.hust.edu;

/**
 * locate com.hust.edu
 * Created by MasterTj on 2019/1/10.
 */
public class TransferMoney {
    public void transferMoney(Account fromAccount, Account toAccount){
        synchronized (fromAccount){
            synchronized (toAccount){
                //do transferMoney
                System.out.println("--------transferMoney--------");
            }
        }
    }
}
