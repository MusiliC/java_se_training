package com.systechafrica.part3.collections;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String regNo;
    private String email;
    private int id;
   

    public Student() {
    }
    public Student(String name, String regNo, String email) {
        this.name = name;
        this.regNo = regNo;
        this.email = email;
    }
    public Student(String name, String regNo, String email, int id) {
        this.name = name;
        this.regNo = regNo;
        this.email = email;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRegNo() {
        return regNo;
    }
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", regNo=" + regNo + ", email=" + email + "]";
    }

    

}
