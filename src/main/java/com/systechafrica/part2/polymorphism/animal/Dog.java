package com.systechafrica.part2.polymorphism.animal;

public class Dog extends AnimalSound {
    public void sound(){
        System.out.println("Dog barks");
    }

    public void sound(String angry){
        System.out.println("Angry dog goes: crawl crawl");
        super.sound();
    }
}
