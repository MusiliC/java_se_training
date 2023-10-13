package com.javasetraining.part4.functionalprograming;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.systechafrica.part4.functionalprograming.Calculator;
import com.systechafrica.part4.functionalprograming.Divider;

public class CalculatorTest {
    Calculator calc = (a, b, numbers) -> {
        int sum = a + b;
        for (int i : numbers) {
            sum += i;
        }

        return sum;
    };

    Divider divider = (a,b) -> a/b;


    @Test
    @DisplayName("Test calculation using calculator")
    void testSum() {      
   
        assertAll(
                () -> assertEquals(14, calc.calculate(7, 7), "Expected result should match"),
                () -> assertEquals(-10, calc.calculate(-5, -5), "Expected result should match"),
                () -> assertEquals(20, calc.calculate(7, 7, 3, 2, 1), "Expected result should match"));
    }

       @Test
    @DisplayName("Test calculation using divid")
    void testDivide() {      
   
        assertAll(
                () -> assertEquals(2, divider.divide(10, 5), "Expected result should match"),
                () -> assertEquals(5, divider.divide(-20, -4), "Expected result should match"),
                () -> assertThrows(ArithmeticException.class,() -> divider.divide( 20, 0) ));
    }
};
