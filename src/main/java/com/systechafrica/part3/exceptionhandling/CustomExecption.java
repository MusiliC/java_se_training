package com.systechafrica.part3.exceptionhandling;

public class CustomExecption {
    public static void main(String[] args) {

        DivisionTest app = new DivisionTest();

        try {
            app.divide();
        } catch (MusiliException e) {
            System.out.println("Error " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Catching arithmetic exception " + e.getMessage());
        }

    }
}
