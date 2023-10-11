package com.systechafrica.part4.utildate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class WorkingWithUtilDate {

    public static void main(String[] args) {
        Date todayDate = new Date();
        System.out.println("Todays date " + todayDate);

        // Calendar calendar =  Calendar.getInstance();
        // calendar.add(Calendar.MONTH, 2);

        //add two days o the date
       // System.out.println(calendar.getTime());

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter date tomorrows: ");
            System.out.println();
            String dateString = scanner.nextLine();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Date tomorrowDate = dateFormat.parse(dateString);   
            
            System.out.println(tomorrowDate);
         

            if (tomorrowDate.after(todayDate)) {
                System.out.println("Valid date");
            }else{
                System.out.println("Please enter a future date");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(todayDate);
        

    }
}
