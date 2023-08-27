package com.java_se_training.looping;

import java.util.logging.Logger;



public class LoopingStatements {

     private static final Logger LOGGER = Logger.getLogger(LoopingStatements.class.getName()); 

     public void forLoop (){
        for(int counter = 0; counter <= 5; counter ++){
            LOGGER.info("Counter " + counter);
        }
     }

    public static void main(String[] args) {
        LoopingStatements app = new LoopingStatements();

        app.forLoop();;
    }
    
}
