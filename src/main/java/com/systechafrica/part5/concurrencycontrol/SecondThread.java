package com.systechafrica.part5.concurrencycontrol;

public class SecondThread implements  Runnable{
    private int threadNumber;
    SynchronizationExample se;

    public SecondThread(int threadNumber, SynchronizationExample se) {
        this.threadNumber = threadNumber;
        this.se = se;
    }

    @Override
    public void run() {

        se.modifySharedValue(threadNumber);
        System.out.println("Thread " + threadNumber + " is running" );
    }
}
