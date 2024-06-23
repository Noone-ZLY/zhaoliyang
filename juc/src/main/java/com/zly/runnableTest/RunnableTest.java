package com.zly.runnableTest;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2024/6/8 16:24
 */
public class RunnableTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("我是" + Thread.currentThread().getName() + "正在进行第" + i + "个测试");
                }
            }
        }).start();

        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.start();
    }
}

/**
 * @param
 * @return null
 * @description 创建Runnable类，实现Runnable接口的run方法
 * @author zhaoliyang
 * @create 2024/6/8 16:29
 */
class RunnableDemo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我是" + Thread.currentThread().getName() + "正在进行第" + i + "个测试");
        }
    }
}
