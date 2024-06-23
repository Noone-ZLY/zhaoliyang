package com.zly.lambdaTest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : zhaoliyang
 * @description :
 * @createDate : 2024/6/9 20:38
 */
public class lambdaTest {
    // 静态内部类
    static class RunnableTest2 implements Runnable{
        @Override
        public void run() {
            System.out.println("i am lambda1");
        }
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        runnableTest.run();

        RunnableTest2 runnableTest2 = new RunnableTest2();
        runnableTest2.run();

        Runnable runnableTest3 = new Runnable(){
            @Override
            public void run() {
                System.out.println("i am lambda3");
            }
        };
        runnableTest3.run();

        Runnable test = ()->{
            System.out.println("i am lambda4");
        };
        test.run();
        int[] nums = new int[]{1, 2, 3,2,4,2,2};
        Arrays.sort(nums,new Comparator<>());
    }
}

class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println("i am lambda1");
    }
}
