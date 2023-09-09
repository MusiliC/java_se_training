package com.systechafrica.restaurant;

public class Main {

    public void displayHotelMenu() {
        System.out.println();
        System.out.println("*****************************************");
        System.out.println();
        System.out.println("SYSTECH RESTAURANT");
        System.out.println();
        System.out.println("DRINKS");
        System.out.println("***************************");
        System.out.println();
        System.out.println("1. CHAI----------------------------15");
        System.out.println("2. ANDAZI---------------------------10");
        System.out.println("3. TOSTI-----------------------------12");
        System.out.println();

        System.out.println("MEALS");
        System.out.println("***************************");
        System.out.println();
        System.out.println("4. NDENGU AND ACCOMPLISHMENTS----------------------------70");
        System.out.println("5. BEANS AND ACCOMPLISHMENTS---------------------------70");
        System.out.println("6. PILAU VEG-----------------------------90");
        System.out.println("7. QUIT");
        System.out.println();

        System.out.print("Choose an your drink/Meal-one item at a time: ");
    }

    public static void main(String[] args) {
        Main app = new Main();

        app.displayHotelMenu();
    }
}
