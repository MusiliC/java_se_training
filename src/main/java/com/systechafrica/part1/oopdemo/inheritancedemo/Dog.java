package com.systechafrica.part1.oopdemo.inheritancedemo;

public class Dog extends Animal{

    private int eyes;
    private int legs;
    private String tail;


    public Dog(String animal, int brain, int size, int weight, int eyes, int legs, String tail){

        super();
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
}


    public int getEyes() {
        return eyes;
    }


    public void setEyes(int eyes) {
        this.eyes = eyes;
    }


    public int getLegs() {
        return legs;
    }


    public void setLegs(int legs) {
        this.legs = legs;
    }


    public String getTail() {
        return tail;
    }


    public void setTail(String tail) {
        this.tail = tail;
    }

    public void chew(){
        System.out.println("Animal eating");
    }


    @Override
    public void eat() {
        // TODO Auto-generated method stub
        super.eat();
        chew();
    }


    @Override
    public String toString() {
        return "Dog [eyes=" + eyes + ", legs=" + legs + ", tail=" + tail + "]";
    }

 
    
}
