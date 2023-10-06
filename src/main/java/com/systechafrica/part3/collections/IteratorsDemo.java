package com.systechafrica.part3.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorsDemo {
    public static void main(String[] args) {
        List<String> MusilinickNames = new ArrayList<String>();
        MusilinickNames.add("Shoto");
        MusilinickNames.add("cee");
        MusilinickNames.add("Mahrez");

        Iterator<String> myNames = MusilinickNames.iterator(); // iterating through collections - allows only next
        ListIterator<String> myNames2 = MusilinickNames.listIterator(); // allows next and previous
        

        while (myNames.hasNext()) {

            System.out.println(myNames.next());
        }

    }
}
