package com.systechafrica.part5.concurrencycontrol;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Java8FeautresConcurrencyControl {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable printNumbers = () -> {
            for (int i=0; i<=5; i++){
                System.out.println(i);
            }
        };
        Runnable printRandomNumbers = () -> {
            for (int i = 0; i <= 5; i++) {
                System.out.println(new Random().nextInt());
            }
        };

        executorService.execute(printNumbers);
        executorService.execute(printRandomNumbers);
    }
}
