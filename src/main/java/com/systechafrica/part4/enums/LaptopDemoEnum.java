package com.systechafrica.part4.enums;

public class LaptopDemoEnum {
    public static void main(String[] args) {
        Laptop[] laptop = Laptop.values();
        
        for (Laptop lap : laptop) {
            System.out.println("Name: " + lap + " - " + "Price: " + lap.getPrice());
        }
    }
}
