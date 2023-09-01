package com.java_se_training.utils;

public class ValidateInput {

    public static final boolean validate(String input){

        if(input  != null && input.length() > 0){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        
    }
}
