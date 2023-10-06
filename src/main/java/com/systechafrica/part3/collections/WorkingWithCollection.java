package com.systechafrica.part3.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkingWithCollection {
    public static void main(String[] args) {
        //workingWithListAndListArray();
       // workingWithSet();
        
    }
    
    // working with objects in list - many methods
    //?  allow duplicates and its ordered
    private static void workingWithListAndListArray() {
        List<Student> students = new ArrayList<Student>();
        Student student = new Student("Cee", "12", "cee@gmail.com", 0);
        Student student2 = new Student("Smith", "13", "smith@gmail.com", 1);
        Student student3 = new Student("Musili", "14", "musili@gmail.com", 1);
        students.add(student);
        students.add(student2);
        students.set(0, student3);
        int k = students.indexOf(student2);
        System.out.println(k);

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

    }

    //working with set interface
    //? does not allow duplicates and its not ordered
    // private static void workingWithSet() {
    //     Student student = new Student("Cee", "12", "cee@gmail.com", 0);
    //     Student student2 = new Student("Smith", "13", "smith@gmail.com", 1);
       
    //     Set<Student> students = new HashSet<>();

    //     students.add(student);
       

    // }
}
