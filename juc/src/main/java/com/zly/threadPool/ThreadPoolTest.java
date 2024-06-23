package com.zly.threadPool;

import java.util.concurrent.*;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/15 15:37
 **/
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0,
                                                                    Integer.MAX_VALUE,
                                                                        60L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(Integer.MAX_VALUE), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 5; i++){
//            Thread.sleep(2000);
            WorkerThread workerThread = new WorkerThread("" + i);
            threadPoolExecutor.execute(workerThread);
        }
    }
}
