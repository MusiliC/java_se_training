package com.systechafrica.looping;

import java.util.logging.Logger;

public class LoopingStatements {

     private static final Logger LOGGER = Logger.getLogger(LoopingStatements.class.getName()); 

     public void forLoop (){
        for(int counter = 0; counter <= 5; counter ++){
            LOGGER.info("Counter " + counter);
        }
     }

     public void whileLoop (){
     int age = 0;

     while (age < 10) {
        LOGGER.info("Student age " + age);
        age++;
       }
     }

     public void doWhileLoop(){
        int age = 0;

        do{
            LOGGER.info("Student age " + age);
            age++;
        }
        while(age < 5);

        String name = "Musili";

       LOGGER.info("String methods " + name.charAt(1));
       LOGGER.info("String methods " + name.trim());
       LOGGER.info("String methods " + name.toUpperCase());
       LOGGER.info("String methods " + name.contains("k"));
       LOGGER.info("String methods " + name.replace("u", "b"));

     }
    
    public int search(int numberToSearch){
        for(int index = 1; index <= 50; index++){
            if(numberToSearch == index){
            return index;
            }
        }
        return 0;
    }
     
    public static void main(String[] args) {
        LoopingStatements app = new LoopingStatements();
        //app.forLoop();
        //app.whileLoop();
        app.doWhileLoop();
        //app.search(12);
    }
    
}
