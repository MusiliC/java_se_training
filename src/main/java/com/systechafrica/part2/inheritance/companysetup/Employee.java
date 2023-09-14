package com.systechafrica.part2.inheritance.companysetup;

public class Employee {
    
    private String employeeNumber;
    private String employeeName;
    private String address;

    
    
    public Employee(String employeeNumber, String employeeName, String address) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.address = address;
    }
    public String getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Employee Details [employeeNumber=" + employeeNumber + ", employeeName=" + employeeName + ", address=" + address
                + "]";
    }

    
    
}
