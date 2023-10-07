package com.systechafrica.part4.utildate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class WorkingWithNewDate {
    public static void main(String[] args) {
        // workingWithLocalDate();
        // workingWithLocalDateTime();
        workingWithLocalTime();
        //duration
        // Period p = Period.ofYears(10);
        Period p = Period.ofMonths(10);
        System.out.println(p);

        LocalDate myDate = LocalDate.now();
        System.out.println("10 months from now " + myDate.plus(p));

    }

    private static void workingWithLocalTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime starTime = LocalTime.of(16, 10, 30);
        LocalTime endTime = starTime.plusHours(2).plusMinutes(30);
        // System.out.println("Start time " + starTime + " " + "End time " + endTime );

        // date time formatter
        DateTimeFormatter df = DateTimeFormatter.ISO_TIME;
        System.out.println("Start time " + df.format(starTime) + " " + "End time " + df.format(endTime));

    }

    // working with local date time
    public static void workingWithLocalDateTime() {
        // format date time
        // DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss");

        // DateTimeFormatter df = DateTimeFormatter.ISO_DATE_TIME; //?default formatter

        DateTimeFormatter df = DateTimeFormatter.ISO_DATE; // ?only take the date component

        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(df.format(currentTime));

        // parsing date using localdate
        try {

            LocalDate localDate = LocalDate.parse("2020-20-20");
            // ? when not using the right format will result to same exception
        } catch (Exception e) {
            System.out.println("Date time exception - error " + e.getMessage());
        }

    }

    // working with local date
    public static void workingWithLocalDate() {
        // ?No 'new' keyword to instantiate
        LocalDate todayDate = LocalDate.now();

        System.out.println(todayDate);
        // ?local date time are immutable, for you to change you to redeclare
        LocalDate futureDate = todayDate.plusDays(5);
        System.out.println("After 5 days " + futureDate);

        // part 2
        System.out.println("Day of birth " + LocalDate.of(2000, 12, 14));
        System.out.println("Day of birth using enums " + LocalDate.of(2000, Month.DECEMBER, 14));

    }

}
