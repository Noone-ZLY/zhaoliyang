package com.zly.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/14 20:57
 **/
public class NewScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        for(int i = 0; i < 5; i++){
            WorkerThread workerThread = new WorkerThread("" + i);
            scheduledThreadPool.execute(workerThread);
        }
        scheduledThreadPool.shutdown();
        while(!scheduledThreadPool.isTerminated()){
        }
        System.out.println("Finished all threads");
    }
}
