package com.systechafrica.part4.functionalprograming;

import java.util.UUID;

public class Lambda {
    public static void main(String[] args) {
        LambdaFunction fun = () -> UUID.randomUUID().toString();

        LambdaFunction fun2 = () -> {
            String randomId = UUID.randomUUID().toString();
            System.out.println(randomId);
            return randomId.substring(5);
        };

        // System.out.println(fun.generateRandomUID());
        // System.out.println(fun2.generateRandomUID());

        // lambda function that returns a value

        GenerateReportInterface report = (student) -> {
            System.out.println("***********SYSTECH INTERNSHIP REPORT**********");
            System.out.println();
            System.out.println("    id: " + student.getId());
            System.out.println("    Name: " + student.getFirstName());
            System.out.println("    Email: " + student.getEmailName());

        };

        Student student = new Student(0, "Musili", "musili@gmail.com");
        Student student2 = new Student(1, "Wambua", "wambua@gmail.com");

        // lambda function with 1 parameter and does not return a value
        report.generateReport(student);
        report.generateReport(student2);

        // lambda function with 2 parameters

        StudentCompare compareStudent = (studentOne, studentTwo) -> {
            return studentOne.getFirstName().equals(studentTwo.getFirstName());
        };

        System.out.println(compareStudent.compare(student, student2));

    }

}
