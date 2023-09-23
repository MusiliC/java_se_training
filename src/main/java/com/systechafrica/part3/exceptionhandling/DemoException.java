package com.systechafrica.part3.exceptionhandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoException {
    public static void main(String[] args) {
        int i, j = 2, k = 0;
        // int a[] = new int[4];
        i = 8;

        Scanner sn = new Scanner(System.in);

        try {
            // out of bound
            // for (int c = 0; c < 4; c++) {
            // {
            // a[c] = c + 1;
            // }
            // }

            // for (int value : a) {
            // {
            // System.out.println(value);
            // }
            // }
            // arithmetic
            System.out.print("Enter value ");
            j = sn.nextInt();
            sn.close();
            k = i + j;
            if(k< 10){
                throw new ArithmeticException();
            }
            System.out.println("Output " + k);

        } catch (ArithmeticException e) {
            System.out.println("Minimum value si less than 10 " + e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input " + e.getMessage());
            sn.next();
            System.out.print("Enter value again: ");
            j = sn.nextInt();
            sn.close();
            k = i / j;
            System.out.println("Output " + k);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Bye");
            sn.close();
        }

    }
}
