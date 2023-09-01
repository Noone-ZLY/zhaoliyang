package com.zly.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/14 20:54
 **/
public class NewFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 5; i++){
            WorkerThread workerThread = new WorkerThread("" + i);
            fixedThreadPool.execute(workerThread);
        }
        fixedThreadPool.shutdown();
        while(!fixedThreadPool.isTerminated()){
        }
        System.out.println("Finished all threads");
    }
}
