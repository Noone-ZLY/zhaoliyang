package com.zly.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * @author zhaoliyang9
 * @des newCacheThreadPool
 * @date 2023/8/14 13:26
 **/
public class NewCacheThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            WorkerThread workerThread = new WorkerThread("" + i);
            cacheThreadPool.execute(workerThread);
        }
        cacheThreadPool.shutdown();
        while(!cacheThreadPool.isTerminated()){
        }
        System.out.println("Finished all threads");
    }
}
