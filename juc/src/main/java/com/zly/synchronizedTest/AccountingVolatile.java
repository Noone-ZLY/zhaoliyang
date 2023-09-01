package com.zly.synchronizedTest;

/**
 * @author zhaoliyang9
 * @des volatile无法解决原子性问题
 * @date 2023/8/17 11:00
 **/
public class AccountingVolatile implements Runnable{
    static AccountingVolatile instance = new AccountingVolatile();
    static volatile int i = 0;

    public static int increase(){
        return i++;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + " Command: " + increase());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(instance);
        Thread thread1 = new Thread(instance);
        thread.start(); thread1.start();
        thread.join(); thread1.join();
        System.out.println(i);
    }
}
