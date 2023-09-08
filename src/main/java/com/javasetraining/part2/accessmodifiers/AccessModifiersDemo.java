package com.javasetraining.part2.accessmodifiers;
import java.util.logging.Logger;

public class AccessModifiersDemo {

    private static final Logger LOGGER = Logger.getLogger(AccessModifiersDemo.class.getName());

    public static void main(String[] args) {
        Person person = new Person("Musili", "musili@gmail.com");
        person.setName("Brian");
        person.setEmail("brian@gmail.com");
        person.getName();
        person.printPersonDetails();
    }
}
