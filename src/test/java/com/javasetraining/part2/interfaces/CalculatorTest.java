package com.javasetraining.part2.interfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.systechafrica.part2.interfaces.Calculator;
import com.systechafrica.part2.interfaces.CalculatorImplementation;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setup() {
       // calculator = new MockCalculator(); //mock because calculator implementation was not provided
        //after test implementation for calculator is provided you can now use it
        calculator = new CalculatorImplementation();
    }

    @Test
    void summation() {

        //inputs
        int a = 10;
        int b = 20;

        //expected results

        int expectedResult = 30;

        //verify results

        int actualResult = calculator.sum(a, b);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    class MockCalculator implements Calculator {

        @Override
        public int sum(int a, int b) {
            return 0;
        }

        @Override
        public int su(int a, int b, int... otherValues) {
            
            return 0;
        }

    }
}
