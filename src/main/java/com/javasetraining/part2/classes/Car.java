package com.javasetraining.part2.classes;

public class Car {
    String color;
    int speed;

    void startEngine(){
        System.out.println("Engine started");
    }

    void accelerate(){
        speed += 10;
        System.out.println("Speed increased to " + speed + " km");
    }
}
