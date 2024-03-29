package com.systechafrica.part1.userinput;

import java.util.Scanner;
import java.util.logging.Logger;

import com.systechafrica.utils.ValidateInput;



public class UserInputUsingScanner {
     private static final Logger LOGGER = Logger.getLogger(UserInputUsingScanner.class.getName()); 

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     //    System.out.print("Enter your two names: ");
     //    String name = sn.next();
     //    String secondName = sn.next();
     //     System.out.print(" Your two names are " + name + " " + secondName);

       System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        
        // Consume the newline character after reading the integer
        scanner.nextLine();
        
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        if(ValidateInput.validate(text)){
          System.out.println("Integer: " + num);
        System.out.println("String: " + text);
        }else{
           throw new IllegalStateException("Invalid input");
      }
           scanner.close();
        
       

     }
}
