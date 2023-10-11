package com.systechafrica.part1.array;


import java.util.ArrayList;

public class ArrayAndArrayList {


    // now using arrayList

    public static void main(String[] args) {

        ArrayList<String> fruitArrayList = new ArrayList<>();

        fruitArrayList.add("Mango");
        fruitArrayList.add("Apple");
        fruitArrayList.add("Orange");
        //add -> adds element at the end
       //replacing array at a certain position
        fruitArrayList.set(0, "PineApple"); 

        // System.out.println(fruitArrayList.get(2));
        // System.out.println(fruitArrayList.size());
        System.out.println(fruitArrayList); //prints the arrays
    

        //arrayList - remove, clear, contains - methods in arrayList


        String[] fruits = new String[3];

        fruits[0] = "Mango";
        fruits[1] = "Apple";
        fruits[2] = "Orange";

        
        System.out.println(fruits); //prints memory allocation
    }
}
