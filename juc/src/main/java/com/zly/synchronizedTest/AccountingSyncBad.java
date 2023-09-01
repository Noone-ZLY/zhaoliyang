package com.zly.synchronizedTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/17 11:31
 **/
public class AccountingSyncBad implements Runnable{
    static AccountingSyncBad instance = new AccountingSyncBad();
    static int i = 0;

    public synchronized int increase(){
        return i++;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + " Command: " + increase());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new AccountingSyncBad());
        Thread thread1 = new Thread(new AccountingSyncBad());
        thread.start(); thread1.start();
        thread.join(); thread1.join();
        System.out.println(i);
    }
}
