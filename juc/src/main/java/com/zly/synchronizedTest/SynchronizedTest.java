package com.zly.synchronizedTest;


/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/17 9:40
 **/
public class SynchronizedTest {
    private static int i = 0;
    private String name;

    public SynchronizedTest(String name) {
        this.name = name;
    }
    public void method(){
        for (int j = 0; j < 100; j++) {
            System.out.println(this.name + " Command:" + ++i);
        }
    }
    /*实例方法加synchronized，获取实例对象的锁，将实例对象锁住*/
    public synchronized void instanceMethodSynchronized(){
        for (int j = 0; j < 100; j++) {
            System.out.println(this.name + " Command:" + ++i);
        }
    }
    /*静态方法加synchronized，获取类对象的锁，将类对象锁住*/
    public synchronized void staticMethodSynchronized(){
        for (int j = 0; j < 100; j++) {
            System.out.println(this.name + " Command:" + ++i);
        }
    }
    /*锁住代码块，锁住的是提供的对象*/
    public void codeBlockSynchronized(){
        synchronized (this){

        }
    }
    public static void main(String[] args) {
        SynchronizedTest thread1 = new SynchronizedTest("Thread1");
        SynchronizedTest thread2 = new SynchronizedTest("Thread2");
//        thread1.staticMethodSynchronized();
//        thread2.staticMethodSynchronized();
//        thread1.instanceMethodSynchronized();
//        thread2.instanceMethodSynchronized();
        thread1.method();
        thread2.method();
    }
}
