package com.systechafrica.part2.accessmodifiers;

public class Person {
    private String name;
    private String email;
    private boolean promoted;

    //getter and setters

    public boolean isPromoted() {
        return promoted;
    }

    public void setPromoted(boolean promoted) {
        this.promoted = promoted;
    }

    public void setName(String name){
        this.name = name;
    };

    public String getName(){
        return this.name;
    };
    public void setEmail(String email){
        this.email = email;
    };

    public Person(){};

    public String getEmail(){
        return this.email;
    };

    public Person(String name, String email){
        this.name = name;
        this.email = email;
    }

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
