package com.java_se_training.operators;

import java.util.logging.Logger;

public class OperatorsDemo {

     private static final Logger LOGGER = Logger.getLogger(OperatorsDemo.class.getName()); 

     public void arithmeticOperators (){
        //addition
        int math = 23;
        int eng = 25;

        int totalMarks = math + eng;
        LOGGER.info(("Total marks " + totalMarks));

        //subtraction
        int diffMarks = eng - math;
        LOGGER.info(("Difference marks " + diffMarks));

         //multiplication
        int multiplyMarks = eng * math;
        LOGGER.info(("Multiply marks " + multiplyMarks));

         //division
        double divideMarks = (double)eng / math;
        LOGGER.info(("division of the marks " + divideMarks));

        //modulus
        int modulaMarks = eng % math;
        LOGGER.info(("modulus of the marks " + modulaMarks));
     }

    public static void main(String[] args) {
        OperatorsDemo app = new OperatorsDemo();
        app.arithmeticOperators();
    }
}
