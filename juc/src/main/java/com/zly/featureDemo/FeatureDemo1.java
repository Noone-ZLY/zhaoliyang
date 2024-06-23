package com.zly.featureDemo;

import java.util.concurrent.*;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2023/10/16 15:05
 */
public class FeatureDemo1 {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() ->{
            try{
                Thread.sleep(1000);
                System.out.println(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            return 1;
        });
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() ->{
            System.out.println(2);
            return 1;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() ->{
            System.out.println(3);
            return 1;
        });

//        future.join();
//        future1.join();
//        future2.join();
        System.out.println("hello");
        Thread.sleep(1000);
    }
}
