package com.zly.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/14 20:59
 **/
public class NewSingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++){
            WorkerThread workerThread = new WorkerThread("" + i);
            singleThreadExecutor.execute(workerThread);
        }
        singleThreadExecutor.shutdown();
        while(!singleThreadExecutor.isTerminated()){
        }
        System.out.println("Finished all threads");
    }
}
