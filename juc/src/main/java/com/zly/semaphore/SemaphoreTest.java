package com.zly.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/25 15:19
 **/
public class SemaphoreTest implements Runnable{
    Semaphore semaphore = new Semaphore(5);
    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ": done!");
            semaphore.release();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        for (int i = 0; i < 20; i++) {
            fixedThreadPool.submit(semaphoreTest);
        }
    }
}
