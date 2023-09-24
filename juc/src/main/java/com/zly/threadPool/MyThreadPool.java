package com.zly.threadPool;

import java.util.concurrent.*;

/**
 * @author : Noone
 * @version : v1.0
 * @createTime : 2023/9/7 16:54
 * @description :
 */
public class MyThreadPool {
    /**
     * 线程池默认参数
     */
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE_SIZE = 10;
    private static final int DEFAULT_KEEP_ALIVE_TIME = 1;
    private static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MINUTES;

    private static final int DEFAULT_BLOCKING_QUEUE_CAPACITY = 10;
    private static final int BLOCKING_QUEUE_CAPACITY = 10;
    /**
     * 可配置参数
     */
    private int corePoolSize = DEFAULT_CORE_POOL_SIZE;
    private int maximumPoolSize = DEFAULT_MAXIMUM_POOL_SIZE_SIZE;
    private long keepAliveTime = DEFAULT_KEEP_ALIVE_TIME;
    private TimeUnit unit = DEFAULT_TIME_UNIT;

    private BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(BLOCKING_QUEUE_CAPACITY);

    public ThreadPoolExecutor getThreadPool(){
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory());
    }
}
