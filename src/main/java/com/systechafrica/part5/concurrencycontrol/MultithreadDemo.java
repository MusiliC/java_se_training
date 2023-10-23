package com.systechafrica.part5.concurrencycontrol;

public class MultithreadDemo {


    public static void main(String[] args) {
        SynchronizationExample se = new SynchronizationExample();
        MyThread firstThread = new MyThread(1, se);
        MyThread secondThread = new MyThread(2, se);

        Thread threadThree = new Thread(new SecondThread(3, se));
        SecondThread threadFour = new SecondThread(4, se);

        Thread t1 = new Thread(() -> {
            System.out.print("My new thread using lambda ");
            System.out.println("is running");
        });

        //System.out.println("Current thread " + Thread.currentThread().getName());

//        firstThread.setPriority(Thread.MIN_PRIORITY);
//        firstThread.setName("First Thread");
//        secondThread.setPriority(Thread.MAX_PRIORITY);
//        threadThree.setPriority(Thread.NORM_PRIORITY);
//        t1.setPriority(8);
       // t1.start();
        firstThread.start();
        firstThread.setPriority(Thread.MIN_PRIORITY);
        secondThread.start();
        threadThree.start();
        threadFour.run();
    }
}
