package com.systechafrica.part4.functionalprograming;

import java.util.List;
import java.util.stream.Stream;

public class FunctionalProgrammingDemo {
    public static void main(String[] args) {
        FunctionalProgrammingDemo app = new FunctionalProgrammingDemo();
        app.filterMapChaining();
    }

    public void lambdaInFunction() {
        List<Integer> integers = List.of(1, 2, 3, 4);

        integers.forEach(number -> System.out.println(number));

    }

    public void filterMap() {
        List<Integer> integers = List.of(1, 2, 3, 4);

        Stream<Integer> stream = integers.stream();

        // stream.filter(number -> evenNumbers(number));
        Stream<Integer> filteredStream = stream.filter(number -> number % 2 == 0);
        // map unctions
        Stream<Integer> squaredIntegerStream = filteredStream.map(number -> mapToSquare(number));

        // display final product

        squaredIntegerStream.forEach(number -> System.out.println(number));

    }

    public void filterMapChaining() {
        List<Integer> integers = List.of(1, 2, 3, 4);

        Stream<Integer> stream = integers.stream();

        stream
            .filter(number -> number % 2 == 0)
            .map(number -> mapToSquare(number))
            .forEach(number -> System.out.println(number));
    }

    public static boolean evenNumbers(int number) {
        return number % 2 == 0;
    }

    public static int mapToSquare(int number) {
        return number * number;
    }

    public void functions() {
        Calculator calculator = (a, b, numbers) -> a + b;
        System.out.println(calculator.calculate(5, 6));

        Calculator calculator2 = (a, b, numbers) -> {
            int sum = a + b;
            for (int number : numbers) {
                sum += number;

            }
            return sum;
        };

        System.out.println(calculator2.calculate(1, 2, 2, 3, 4));
    }

    // Calculator calculator = new Calculator() {

    // @Override
    // public int calculate(int a, int b) {
    // return a + b;
    // }

    // };
}
