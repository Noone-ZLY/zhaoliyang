
package com.zly;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : Noone
 * @version : v1.0
 * @createTime : 2023/9/14 20:42
 * @description :
 */
public class Main {
    static int num = 100;
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 100; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (Main.class){
                        num--;
                    }
                }
            }).start();
        }
        Thread.sleep(100);
        System.out.println(num);
    }
}
