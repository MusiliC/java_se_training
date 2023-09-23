package com.systechafrica.part1.variables;

import java.util.logging.Logger;

public class VariableScope {

     private static final Logger LOGGER = Logger.getLogger(VariableScope.class.getName()); 

    // ? Class variable accessed anywhere within the class
    
    private int matchesPlayed = 3;

     public void simpleMethod(){
        LOGGER.info("Hi simple method " + matchesPlayed);
     }

     public int addTwoNumbers(int a, int b){  //? Method variables
        int result = a + b;
        return result;
     }


     public void complexMethod(){
        LOGGER.info("Hi complex method " + matchesPlayed);
     }


    public static void main(String[] args) {
        VariableScope app = new VariableScope();

        app.simpleMethod();
        app.complexMethod();

        LOGGER.info("Matches played " + app.matchesPlayed);
    }   
}
