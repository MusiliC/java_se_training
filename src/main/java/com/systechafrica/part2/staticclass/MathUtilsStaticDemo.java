
package com.systechafrica.part2.staticclass;

public class MathUtilsStaticDemo {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        System.out.println(MathUtilis.Calculator.multiply(a, b));
        System.out.println(MathUtilis.Calculator.sum(a, b));
    }

    private String operationName;

    public void printInfo(){
        System.out.println(operationName);
    }

    private static class Calculator {
        public static int add(int a, int b) {
            MathUtilsStaticDemo math = new MathUtilsStaticDemo();
            math.operationName = "kk"; //?accessing non static members you create instance
            math.printInfo(); //! same way to methods
            return a + b;
        }
        public static int add(int a, int b, int c) {
            return a + b + c;

        }

        public static int multiply(int a, int b){
            return a*b;
        }
    }



    public static class AreaMath extends Calculator{
        public static int square(int a, int b){
           return Calculator.multiply(a, b);
        }
    }
}
