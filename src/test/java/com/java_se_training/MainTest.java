package com.java_se_training;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    //? References => Main Class
    Main main = new Main();
    
    @Test
    void add(){
        //when
        int result = main.add(2, 3);

        //then
        int expected = 5;

        //verify that ? result == expected
        Assertions.assertEquals(expected, result, "The sum of 2 + 3 = 5 ");

    }
}
