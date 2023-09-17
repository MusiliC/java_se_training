package com.systechafrica.part2.casting;

import oopdemo.inheritancedemo.Animal;
import oopdemo.inheritancedemo.Dog;

public class CastingDemo {
    public static void main(String[] args) {
        CastingDemo app = new CastingDemo();
        Animal animal = new Dog("German", 2, 10, 10, 2, 4, "two"); //up-casting  - reference of base class to refer to object in child class - implicit
        app.printInfo(animal);

    }
    
    public void printInfo(Animal animal){
        Dog dog = (Dog) animal;
      dog.eat();
    }
}
