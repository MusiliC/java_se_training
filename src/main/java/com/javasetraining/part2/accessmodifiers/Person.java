package com.javasetraining.part2.accessmodifiers;

public class Person {
    private String name;
    private String email;

    public void toStringMethod(){
        System.out.println(email);
    }

    public void printPersonDetails(){
        System.out.println(email + " " + name);
    }

    private String getPersonalDetails(){
        return email + " " + name;
    }
}
