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

     public void assignmentOperators (){
        int quantity = 45;

        //additional
        // quantity= quantity + 10;
        quantity += 10;

        LOGGER.info("quantity: " + quantity);

        //multiply
         quantity *= 10;

         LOGGER.info("quantity: " + quantity);

         //equivalent
         quantity /= 10;

         LOGGER.info("quantity: " + quantity);
     }
    
     public void comparisonOperators(){
        int eng = 40;
        int math = 40;

        //equal
        boolean isEqual = eng == math;
        LOGGER.info("Comparison " + isEqual);

        //not equal
          boolean notEqual = eng != math;
        LOGGER.info("Comparison not equal " + notEqual);

        //greater
          boolean isCheckingGreater = eng > math;
        LOGGER.info("Comparison greater " + isCheckingGreater);

        //greater or equal
           boolean isCheckingGreaterOrEqual = eng >= math;
        LOGGER.info("Comparison greater or equal " + isCheckingGreaterOrEqual);


        //less
          boolean isCheckingLess = eng < math;
        LOGGER.info("Comparison lesser " + isCheckingLess);

        //greater or less
           boolean isCheckingLessOrEqual = eng <= math;
        LOGGER.info("Comparison greater or equal " + isCheckingLessOrEqual);
     }
    
     public static void main(String[] args) {
        OperatorsDemo app = new OperatorsDemo();
        // app.arithmeticOperators();
        //app.assignmentOperators();
        app.comparisonOperators();
    }
}
