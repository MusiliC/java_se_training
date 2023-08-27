package com.java_se_training.controller;

import java.util.logging.Logger;

public class ControlFlow {

    private static final Logger LOGGER = Logger.getLogger(ControlFlow.class.getName()); 

    public void ifElseStatement (){
           int math = 90;

        if(math > 100){
            LOGGER.info("Invalid marks");
         }
       else if(math >= 80 && math <= 100){
            LOGGER.info("A");
        }else if( math >= 70){
            LOGGER.info("A");
        }
        else if(math >= 60){
            LOGGER.info("C");
        }
        else if(math >= 50){
            LOGGER.info("D");
              
        }else{
            LOGGER.info("Failure! Failure!, amka enda ufanye kazi!");
        }
    }

    public void switchStatements(){
        String day = "SUNDAY";

        switch (day) {
            case "MONDAY":
                LOGGER.info("Monday working day");
                break;
            case "TUESDAY":
                LOGGER.info("Tuesday working day");
                break;
            case "WEDNESDAY":
                LOGGER.info("Wednesday working day");
                break;
            case "THURSDAY":
                LOGGER.info("Thursday working day");
                break;
            case "FRIDAY":
                LOGGER.info("Friday working day");
                break;
            case "SATURDAY":
            case "SUNDAY":
                LOGGER.info("Tupige sherehe");
                break;
                
        
            default:
                LOGGER.info("Please specify a working day");
                break;
        }
    }

    public static void main(String[] args) {
        ControlFlow app = new ControlFlow();

        //app.ifElseStatement();
         app.switchStatements();
    }
}
