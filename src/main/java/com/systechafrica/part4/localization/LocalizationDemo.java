package com.systechafrica.part4.localization;

import java.util.Arrays;
import java.util.Locale;

public class LocalizationDemo {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale);

       // Arrays.stream(Locale.getAvailableLocales()).forEach(System.out::println);

        locale = new Locale.Builder()
                .setLanguage("Fr")
                .setRegion("FR")
                .build();

        System.out.println(locale);
    }
}
