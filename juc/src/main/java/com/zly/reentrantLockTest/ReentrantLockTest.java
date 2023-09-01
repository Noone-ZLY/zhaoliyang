package com.zly.reentrantLockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/17 11:38
 **/
public class ReentrantLockTest implements Runnable{
    Lock lock = new ReentrantLock();
    volatile static int j = 0;
    @Override
    public void run() {
        for(int i = 0; i < 1000000; i++){
            lock.lock();
            try{
                j++;
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        Thread t1 = new Thread(reentrantLockTest);
        Thread t2 = new Thread(reentrantLockTest);
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println(ReentrantLockTest.j);
    }
}
