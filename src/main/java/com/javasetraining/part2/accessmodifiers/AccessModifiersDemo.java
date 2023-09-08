package com.javasetraining.part2.accessmodifiers;
import java.util.logging.Logger;

public class AccessModifiersDemo {

    private static final Logger LOGGER = Logger.getLogger(AccessModifiersDemo.class.getName());

    public static void main(String[] args) {
        Person person = new Person();

        person.printPersonDetails();
    }
}
