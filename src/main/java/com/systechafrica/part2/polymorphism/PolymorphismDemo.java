package com.systechafrica.part2.polymorphism;

import com.systechafrica.part2.polymorphism.animal.AnimalSound;
import com.systechafrica.part2.polymorphism.animal.Cow;
import com.systechafrica.part2.polymorphism.animal.Dog;

public class PolymorphismDemo {
    public static void main(String[] args) {
        AnimalSound animal = new AnimalSound();
        Cow cow = new Cow();
        Dog dog = new Dog();
        animal.sound();
        cow.sound();
        dog.sound();
        dog.sound("grawl");
    }
}
