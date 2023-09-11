package oopdemo.inheritancedemo;

public class Main {
    public static void main(String[] args) {
       Dog dog = new Dog("Bruno", 1, 2, 10, 2, 4, "one") ;
       System.out.println(dog);
       dog.eat();
    }
}
