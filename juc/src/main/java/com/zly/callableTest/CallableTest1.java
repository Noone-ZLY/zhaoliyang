package com.zly.callableTest;

import java.util.concurrent.*;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2024/6/8 15:13
 */
public class CallableTest1 {
    public static void main(String[] args) throws Exception{
        System.out.println("测试Callable开始");
        CallableTest<String> test = new CallableTest<>();

        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        Future<String> future = threadPool.submit(test);
        String ans = future.get();
        System.out.println(ans);
        System.out.println("hello");
        return;
    }

}

class CallableTest<String> implements Callable{
    @Override
    public String call() throws Exception {
        String res = null;
        for (int i = 0; i < 100; i++) {
            System.out.println("我是Callable,正在处理" + i);
        }
        Thread.sleep(1000);
        res = (String) "Callabel处理完成，我是Callable返回的结果";
        return res;
    }
}
