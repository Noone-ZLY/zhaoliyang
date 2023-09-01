package com.zly.waitAndNotifyTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/7/1 15:01
 **/
// wait, notify是Object类的方法
// wait和notify必须要获得其对象的锁，才可以使用
// notify唤醒对象时，Object.wait不能立马结束，需要获取到对象锁才能继续执行
public class WaitAndNotifyTest {
    final static Object object = new Object();
    public static class t1 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis() + ": T1 start! ");
                try{
                    object.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ": T1 end! ");
            }
        }
    }

    public static class t2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis() + ": T2 start! ");
                object.notify();
                System.out.println(System.currentTimeMillis() + ": T2 end! ");
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        t1 t1 = new t1();
        t2 t2 = new t2();
        t1.start();
        t2.start();
    }
}
