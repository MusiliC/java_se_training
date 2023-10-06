package com.systechafrica.part2.staticclass;

public class MathUtilis {
    public static class Geometry{
        public static double calculateArea(double x, double y){
            return x*y;
        }
        public static double calculatePerimeter(double x, double y){
            return (x+y)*2;
        }
    }

    public static class Calculator{
        public static int sum(int a, int b){
            return a+b;
        }
        public static int multiply(int a, int b){
            return a*b;
        }

        public static int sum(int a, int b, int... numbers){
            int sum = a + b;
            for (int i = 0; i<= numbers.length; i++){
                sum = sum + numbers[i];
            }

            return sum;
        }
    }
}
