package com.systechafrica.part5.concurrencycontrol;

public class SynchronizationExample {
    private  int sharedVariable = 0;
    public synchronized void modifySharedValue (int a){
        sharedVariable += a;
        System.out.println(sharedVariable);
    }
}
