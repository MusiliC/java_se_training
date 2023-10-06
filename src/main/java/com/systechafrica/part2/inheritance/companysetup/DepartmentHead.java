package com.systechafrica.part2.inheritance.companysetup;

public class DepartmentHead extends Employee {
    private String title;

    

    public DepartmentHead(String employeeNumber, String employeeName, String address, String title) {
        super(employeeNumber, employeeName, address);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
}
