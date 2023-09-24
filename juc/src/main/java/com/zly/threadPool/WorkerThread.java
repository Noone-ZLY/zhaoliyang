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
        processCommand(2000);
        System.out.println(Thread.currentThread().getName() + " End. Command" + command);
    }

    private void processCommand(int runTime){
        try {
            Thread.sleep(runTime);
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
