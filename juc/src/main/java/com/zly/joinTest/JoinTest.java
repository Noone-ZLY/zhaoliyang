package com.zly.joinTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/7/1 15:50
 **/
public class JoinTest{
    public volatile static int i = 0;
    public static class AddThread extends Thread{
        @Override
        public void run() {
            for(i = 0; i < 10000; i++);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        AddThread addThread = new AddThread();
        addThread.start();
        addThread.join();
        System.out.println(i);
    }
}
