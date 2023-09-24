package com.systechafrica.exceptionhandling;

public class ZeroNegativeErrorHandling extends Exception {
    public ZeroNegativeErrorHandling(){
        super("Invalid input, enter valid input");
    }

    public ZeroNegativeErrorHandling (String message){
        super(message);
    }

}
