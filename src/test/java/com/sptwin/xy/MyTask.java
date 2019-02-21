package com.sptwin.xy;

public class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }
    @Override
    public void run() {
        System.out.println("线程名称："+Thread.currentThread().getName());
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
