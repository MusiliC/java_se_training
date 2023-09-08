package com.systechafrica;

import java.util.logging.Logger;


public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName()); 
    public static void main(String[] args) {
        LOGGER.info("Hello world!");
    }

    public int add(int a , int b){
        return a + b;
    }

    public double computeCircleArea(double radius){
        return Math.PI * radius * radius;
    }

    public char determineGrade(int numberGrade){
        if(numberGrade < 0){
            throw new IllegalArgumentException("Number grade cannot be empty");
          
        }
        else if(numberGrade < 60){
            return 'F';
        }
        else if(numberGrade < 70){
            return 'D';
        }
        else if(numberGrade < 80){
            return 'C';
        }
        else if(numberGrade < 90){
            return 'B';
        }
        else {
            return 'A';
        }
    }
}