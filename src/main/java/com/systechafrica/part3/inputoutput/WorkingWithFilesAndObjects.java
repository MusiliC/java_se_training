package com.systechafrica.part3.inputoutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.systechafrica.part3.collections.Student;

public class WorkingWithFilesAndObjects {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        File quoteFile = new File("student.txt");
        Student Musili = new Student("Brayo", "22", "cee@gmail.com");

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(quoteFile));
            oos.writeObject(Musili);
            oos.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(quoteFile));
        Student reaStudent = (Student) ois.readObject();
        System.out.println(reaStudent);
        ois.close();
    }
}
