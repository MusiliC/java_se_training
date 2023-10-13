package com.systechafrica.part4.functionalprograming;

public class Student {
    private int id;
    private String firstName;
    private String secondName;
    private String emailName;

    public Student() {
    }

    

    public Student(int id, String firstName, String secondName, String emailName) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailName = emailName;
    }

     public Student(int id, String firstName, String emailName) {
        this.id = id;
        this.firstName = firstName;        
        this.emailName = emailName;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
        result = prime * result + ((emailName == null) ? 0 : emailName.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (id != other.id)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (secondName == null) {
            if (other.secondName != null)
                return false;
        } else if (!secondName.equals(other.secondName))
            return false;
        if (emailName == null) {
            if (other.emailName != null)
                return false;
        } else if (!emailName.equals(other.emailName))
            return false;
        return true;
    }

    

    

}
