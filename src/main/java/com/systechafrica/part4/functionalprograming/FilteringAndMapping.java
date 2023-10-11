package com.systechafrica.part4.functionalprograming;

import java.util.List;
import java.util.stream.Collectors;

public class FilteringAndMapping {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(100, 200, 100, 200, 100, 33, 53, 14, 65, 69, 7000, 833, 90);
        // getStudentDtos();
        // getSum(numbers);

        // long allNum = SumAndReduce(numbers);
        // System.out.println("Count " + allNum);

        // getMaxAndMinimum(numbers);

        // getFindAllAndAny(numbers);

        intermediateFunctions(numbers);

    }

    private static void intermediateFunctions(List<Integer> numbers) {
        int anyNumber = numbers.stream()
                .findAny()
                .get();

        System.out.println(anyNumber);

        List<String> nickNames = List.of("Cee", "Mahrez", "Lefty", "Kasee");
        String firstName = nickNames.stream()
                .findFirst()
                .get();

        System.out.println(firstName);

        // methods
        System.out.println("Limiting");
        numbers.stream()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("Skipping and limiting");
        numbers.stream()
                .skip(4)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("Sorting");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Distinct");
        numbers.stream()
                .sorted()
                .distinct()
                .forEach(System.out::println);

            System.out.println("Peek");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void getFindAllAndAny(List<Integer> numbers) {
        boolean findAny = numbers.stream()
                .anyMatch(x -> x > 100);

        System.out.println("Find any > 100: " + findAny);

        boolean findAll = numbers.stream()
                .allMatch(x -> x > 10);

        System.out.println("Find All > 10: " + findAll);
    }

    private static void getMaxAndMinimum(List<Integer> numbers) {
        int minimum = numbers.stream()
                .mapToInt(Integer::intValue)
                .min().getAsInt();
        System.out.println("Minimum " + minimum);

        int max = numbers.stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();
        System.out.println("Maximum " + max);
    }

    private static long SumAndReduce(List<Integer> numbers) {
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum " + sum);
        // ?reducer used when you want to change the initial value
        int product = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product " + product);

        long allNum = numbers.stream()
                .count();
        return allNum;
    }

    private static void getSum(List<Integer> numbers) {
        int sum = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .forEach(System.out::println);

        ;
    }

    private static void workingWithFilterAndMapObjects() {
        List<Student> students = List.of(
                new Student(1, "Musili", "Brian", "musili@gmail.com"),
                new Student(2, "Cee", "014", "cee@gmail.com"),
                new Student(3, "Mahrez", "Lefty", "mahrez@gmail.com"),
                new Student(4, "Juma", "Mesh", "juma@gmail.com"),
                new Student(5, "Ian", "Mayani", "ian@gmail.com"));

        List<StudentDto> studentDtos = students.stream()
                .filter(student -> student.getId() % 2 != 0)
                .map(FilteringAndMapping::mapTStudentDto)
                .collect(Collectors.toList());

        for (StudentDto student : studentDtos) {
            System.out.println(student);
        }
    }

    static private StudentDto mapTStudentDto(Student student) {
        return new StudentDto(student.getFirstName(), student.getEmailName());
    }
}
