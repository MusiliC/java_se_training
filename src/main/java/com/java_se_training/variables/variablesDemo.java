package com.java_se_training.variables;

import java.util.logging.Logger;

public class variablesDemo {

    private static final Logger LOGGER = Logger.getLogger(variablesDemo.class.getName()); 

    private void constantVariables () {
              //constant variable //constants - upper case letters
        // ? final keyword -> type -> variable name -> = -> value -> ;
        final double PI = 3.1242;
        LOGGER.info("Constant variable PI is: " + PI);
    }
    private void integerTypes(){
          //integer variables
          int score = 0;
        LOGGER.info("Score value is: " + score); 
        LOGGER.info("Maximum value for integer: " + Integer.MAX_VALUE );
    }
    private void floatingTypes(){
        float floatNumber = 1.22F;
        LOGGER.info("Floating value: " + floatNumber);
        
    }
    private void charTypes(){
        char grade = 'A';
        LOGGER.info("Your grade is: " + grade);
        
    }
    private void booleanTypes(){
        boolean isSubmitted = true;
        LOGGER.info("Your submitted? " + isSubmitted);
        
    }

    public static void main(String[] args) {

        variablesDemo demo = new variablesDemo();

        demo.integerTypes();
        demo.constantVariables();
        demo.floatingTypes();
        demo.charTypes();
        demo.booleanTypes();
     
    }

}
