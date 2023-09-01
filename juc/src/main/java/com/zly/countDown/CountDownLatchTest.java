package com.zly.countDown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/25 15:26
 **/
public class CountDownLatchTest implements Runnable{

    @Override
    public void run() {

    }

    public static void main(String[] args) throws Exception{
        int size = 20;
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(size);
        CountDownLatch countDownLatch = new CountDownLatch(size);

        for(int i = 0; i < size; i++){
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ": done!");
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println("hello");
        fixedThreadPool.shutdown();
    }
}
