package com.zly.synchronizedTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/17 11:14
 **/
public class AccountingSync implements Runnable{
    static AccountingSync instance = new AccountingSync();
    static int i = 0;

    public static int increase(){
        return i++;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (instance){
                System.out.println(Thread.currentThread().getName() + " Command: " + increase());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new AccountingSync());
        Thread thread1 = new Thread(new AccountingSync());
        thread.start(); thread1.start();
        thread.join(); thread1.join();
        System.out.println(i);
    }
}
