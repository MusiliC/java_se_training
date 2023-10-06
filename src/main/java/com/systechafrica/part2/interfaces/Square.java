package com.systechafrica.part2.interfaces;

public class Square implements CalculateArea, CalculatePerimeter {

    @Override
    public double CalculateAreaMethod(double a, double b) {
        return a * b;
    }

    // @Override
    // public double sum(int a, int b) {
    //     return a * b;
    // }

    @Override
    public double CalculatePerimeterMethod(double a, double b) {
        return (a+b)*2;

    }
    
    
}
