package com.zly.semaphore;

import com.zly.threadPool.MyThreadPool;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : Noone
 * @version : v1.0
 * @createTime : 2023/9/7 16:51
 * @description :
 */

public class SemaphoreAndThreadPoolTest {
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(10);
        MyThreadPool myThreadPool = new MyThreadPool();
        ThreadPoolExecutor threadPool = myThreadPool.getThreadPool();
        for(int i = 0; i < 100; i++){
            threadPool.execute(() ->{
                System.out.println(threadPool.getQueue().size());
                try {
                    semaphore.acquire();
                    System.out.println("得到"+Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    semaphore.release();
                    System.out.println("lose"+Thread.currentThread().getName());
                }
            });
        }
    }
}
