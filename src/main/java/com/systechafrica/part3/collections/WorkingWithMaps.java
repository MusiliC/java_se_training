package com.systechafrica.part3.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class WorkingWithMaps {
    public static void main(String[] args) {
        // Map<KT, VT> map;
        List<String> MusilinickNames = new ArrayList<String>();
        MusilinickNames.add("Shoto");
        MusilinickNames.add("cee");
        MusilinickNames.add("Mahrez");

        List<String> BrianNickNames = new ArrayList<String>();
        BrianNickNames.add("Kasee");
        BrianNickNames.add("Fisi");
        BrianNickNames.add("Master");

        Map<String, List<String>> students = new HashMap<>();
        Map<String, String> studentName = new HashMap<>();

        studentName.put("studentNickNames", "Ghasia");
        System.out.println(studentName);
        Set<Entry<String, String>> entrySet2 = studentName.entrySet();

        for (Entry<String, String> yo : entrySet2) {
            System.out.println(yo.getValue());
        }

        students.put("Brian", BrianNickNames);
        students.put("Musili", MusilinickNames);

        System.out.println(students); // hashmap object

        Set<Entry<String, List<String>>> entrySet = students.entrySet(); // ?Entry has a key and a value
        Collection<List<String>> values = students.values(); // ?returns the value
        Set<String> keySet = students.keySet(); // ?returns the keys in an entry set

        for (Entry<String, List<String>> keyValue : entrySet) {
            keyValue.getKey(); // getting key
            keyValue.getValue(); // getting value

            System.out.println(keyValue.getKey() + " " + keyValue.getValue()); // mapping through
        }

    }
}
