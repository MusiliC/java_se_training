package com.systechafrica.part2.interfaces;

public class CalculatorImplementation implements Calculator {

    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    @Override
    public int su(int a, int b, int... otherValues) {
        int sum = a + b;

        for (int i : otherValues) {
            sum = sum + i;
        }

        return sum;
    }
    
}
