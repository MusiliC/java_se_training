package com.systechafrica.part4.enums;

import java.util.Scanner;

public class EnumDemo {

    public static void main(String[] args) {
        // ifElseMethod();
         switchMethod();
    }

    public static void ifElseMethod() {
        Status[] s = Status.values();
        // ?iterating through the values of enums
        for (Status status : s) {
            System.out.println(status);

            // ?If else statements with enums
            if (status == Status.PENDING) {
                System.out.println("Status pending");
            } else if (status == Status.SUCCESSFUL) {
                System.out.println("Status successful");
            }
        }
    }

    public static void switchMethod() {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the status (SUCCESSFUL, PENDING, FAILED): ");
        String userInput = scanner.nextLine().toUpperCase(); 

        Status status;

        try {
            status = Status.valueOf(userInput); // Convert the user input to an enum value
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid status entered. Please enter one of the following: SUCCESSFUL, PENDING, FAILED");
            scanner.close();
            return;
        }

        switch (status) {
            case PENDING:
                System.out.println("Status pending");
                break;

            case SUCCESSFUL:
                System.out.println("Status successful");
                break;

            default:
                break;
        }

        scanner.close();
    }

    

}
