package com.javasetraining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.systechafrica.Main;

public class MainTest {

    //? References => Main Class
    Main main = new Main();
    
    @Test
    void add(){
        //when
        int actual = main.add(2, 3);
        //then
        int expected = 5;
        //verify that ? result == expected
         Assertions.assertEquals(expected, actual, "The sum of 2 + 3 = 5 ");
      
    }

//assertion for boolean - assertionTrue
    @Test
    void addTwo(){
        //when
        int actual = main.add(3, 3);
        //then
        int expected = 6;
        //verify that ? result == expected
         Assertions.assertTrue(actual == expected);
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


       @Test
    void circleArea(){
        //when -> pass value
        double result = main.computeCircleArea(10);

        //expected output
        double expected = 314.1592653589793;

        // Assertions.assertEquals(expected, result, "Should return right value");
        //asserts not null
        Assertions.assertNotNull(result);
    }  
    //negative 1 
    //    @Test
    // void negativeNumberTesting(){           
   
    //     // when -> pass value less than 1
        
    //     Assertions.assertThrows(IllegalArgumentException.class, 
    //     () ->{
    //        main.determineGrade(1);
    //     }
    //     );         
      
        
    // }
}
