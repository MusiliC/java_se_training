package com.systechafrica.part5.concurrencycontrol;

public class MyThread extends  Thread{
    private int threadNumber;
    SynchronizationExample se;

    public MyThread(int threadNumber, SynchronizationExample se) {
        this.threadNumber = threadNumber;
        this.se = se;
    }

    @Override
    public void run() {

        se.modifySharedValue(threadNumber);
        System.out.println("Thread " + threadNumber + " is running" );
    }
}
