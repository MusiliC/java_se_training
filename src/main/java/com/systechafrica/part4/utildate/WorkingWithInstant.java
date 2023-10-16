package com.systechafrica.part4.utildate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class WorkingWithInstant {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
        ZonedDateTime nowz = ZonedDateTime.now();
        System.out.println(nowz);
        ZonedDateTime americaChicago = ZonedDateTime.now(ZoneId.of("Europe/Chicago"));
        System.out.println(americaChicago);
    }
}
