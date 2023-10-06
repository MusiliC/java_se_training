package com.systechafrica.part2.inheritance.companysetup;

public class SoftwareEngineer extends Employee {
    private String title;

    public SoftwareEngineer(String employeeNumber, String employeeName, String address, String title) {
        super(employeeNumber, employeeName, address);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "Employee Details [employeeNumber=" + getEmployeeNumber() + " title " + getTitle() + ", employeeName="
                + getEmployeeName() + ", address=" + getAddress()
                + "]";
    }

}
