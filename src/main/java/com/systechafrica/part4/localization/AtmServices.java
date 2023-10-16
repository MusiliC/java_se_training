package com.systechafrica.part4.localization;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AtmServices {

    public static void main(String[] args) {
        login();
    }

    static private void login(){
        Locale locale = Locale.GERMANY;
        System.out.println(getProperty(locale, "log-success"));
        System.out.println(getProperty(locale, "choose-option"));
    }

    public static String getProperty(Locale locale, String key){
        ResourceBundle rb = ResourceBundle.getBundle("ATM", locale);
        return rb.getString(key);
    }
}
