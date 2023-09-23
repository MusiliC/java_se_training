package com.systechafrica.part3.exceptionhandling;

public class UserDefinedException {
    public static void main(String[] args) {
        {
            int i = 5;

            if (i<10) {
                try {
                    throw new MyExecption("Error");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

}


class MyExecption extends Exception {
    public MyExecption (String message){
        super(message);
    }
}