package com.zly.condition;

import jdk.nashorn.internal.ir.CallNode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/7/24 14:14
 **/
public class ConditionTest implements Runnable{
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            lock.lock();
            try {
                System.out.println("hello");
            }finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) throws Exception{
        ConditionTest conditionTest = new ConditionTest();
        Thread t1 = new Thread(conditionTest);
        Thread t2 = new Thread(conditionTest);
    }
}
