package com.zly.threadPool;

/**
 * @author zhaoliyang9
 * @des
 * @date 2023/8/14 13:20
 **/
public class WorkerThread implements Runnable{
    private String command;

    public WorkerThread(String command) {
        this.command = command;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Command" + command);
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Command" + command);
        processCommand();
    }

    private void processCommand(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "WorkerThread{" +
                "command='" + command + '\'' +
                '}';
    }
}
