package com.systechafrica.part1.stringbuilder;

import java.util.Scanner;

public class StringBuilderDemo {
    public static void main(String[] args) {
     normalStringBuilder();
    }

    public static void buffer(){
           StringBuffer sb = new StringBuffer("Hello");

           //string buffer and builder are mutable

        sb.append(" world");
        sb.insert(1, "Kenya");
        sb.delete(1, 6);

        System.out.println(sb);
    }

    public static void normalStringBuilder(){
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();
        
        System.out.println("Enter some text, type (exit) to exit: ");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            sb.append(input).append("\n");
        }

        System.out.println("User input: ");
        System.out.println(sb.toString());

        scanner.close();
    
    }
}
