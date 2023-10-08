package com.systechafrica.part4.functionalprograming;

@FunctionalInterface
public interface Calculator {
    int calculate(int a, int b, int... numbers);

    default int sum(int a, int b){
        return a + b;
    }

    static void printInfo(){
        System.out.println("Functional programming");
    }
}
