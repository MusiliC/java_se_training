package com.systechafrica.part3.exceptionhandling;

 public class DivisionTest {
    public void divide() throws MusiliException {
        int i, j;
        i = 8;
        j = 0;

        if (j == 0) {
            throw new MusiliException("This is not possible");
        }
        int k = i / j;

        System.out.println(k);
    }
}
