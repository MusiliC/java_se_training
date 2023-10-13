package com.systechafrica.part4.functionalprograming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Student, Boolean> studentFunction = student -> student.getEmailName().equals("dummy@gmail.com");

        Student student = new Student(0, "Musili", "musili@gmail.com");
        Student student2 = new Student(1, "Wambua", "wambua@gmail.com");

        BiFunction<Student, Student, Boolean> studentCompare = (studentA, studentB) -> {
            System.out.println(studentA.getFirstName());
            System.out.println(studentB.getFirstName());

            return studentA.getFirstName().equalsIgnoreCase(studentB.getFirstName());
        };

        System.out.println(studentFunction.apply(student));
        System.out.println(studentCompare.apply(student, student2));
    }
}
