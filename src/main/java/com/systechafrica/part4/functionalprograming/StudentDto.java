package com.systechafrica.part4.functionalprograming;

public class StudentDto {
    private String firstName;
    private String emailName;
    public StudentDto(String firstName, String emailName) {
        this.firstName = firstName;
        this.emailName = emailName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmailName() {
        return emailName;
    }
    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }
    @Override
    public String toString() {
        return "StudentDto - > firstName = " + firstName + ", emailName = "  + emailName;
    }

    
}
