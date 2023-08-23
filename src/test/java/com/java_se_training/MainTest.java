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

//assertion for boolean - assertionTrue
    @Test
    void addTwo(){
        //when
        int result = main.add(3, 3);
        //then
        int expected = 6;
        //verify that ? result == expected
         Assertions.assertTrue(result == expected);
    }

    //testing
    @Test
    void determineF(){

        // when -> pass value less than 60
        char result = main.determineGrade(30);
        char expected = 'F';
        //expected => F   
        Assertions.assertEquals(expected, result);
        
    }

        //testing
    @Test
    void determineD(){

          
        // when -> pass value less than 60
        char result = main.determineGrade(68);
        
        //expected => D  
        char expected = 'D';
        Assertions.assertEquals(expected, result);
        
    }
}
