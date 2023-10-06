package com.systechafrica.part2.interfaces;

public interface CalculateArea {
    public abstract double CalculateAreaMethod(double a, double b);
    double area = 10;
    public static final double myArea = 20;
    //?They are both the same

    // ! If you are creating a method in interface and you don't want it to appear in classes implemented you add "DEFAULT" keyword and implement the method
    default double sum(int a, int b){
        return a+b;
    }

    //!if you want to override in class of your choice you can override the sum method

}
