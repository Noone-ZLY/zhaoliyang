package com.zly.volatileTest;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/7/1 16:52
 **/
public class volatileTest {
    public volatile static int i = 0;
    
    public static class Thread1 extends Thread{
        public static synchronized void increase(){
            i++;
        }

        @Override
        public void run() {
            for(int k = 0; k < 1000; k++){
                increase();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException{
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
