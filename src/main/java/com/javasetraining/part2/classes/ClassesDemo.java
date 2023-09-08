package com.javasetraining.part2.classes;

public class ClassesDemo {

    public static void main(String[] args) {
        ClassesDemo app = new ClassesDemo();

        app.interns();
        //app.calculatorMethod();
        //app.carInstances();
    }

    public void calculatorMethod(){
        Calculator calculator = new Calculator(); // !Calculator - constructor - special method for creating instance of particular  class - they do not have return types - only function name - with access modifier - have same name as class

        calculator.welcomeMessage();

        int result = calculator.sum(2,3);

        System.out.println("Answer is " + result);
    }

    public void interns() {
        Intern musili = new Intern("Musili Brian","musili@gmail.com",  "07112233");

        musili.doAssignment();
        musili.attendClass();
        System.out.println(musili.name);

        Intern winnie = new Intern();

        winnie.name = "Winnie Kimani";
        winnie.email = "Winnie@gmail.com";
        winnie.name = "07112233";

        winnie.doAssignment();
        winnie.attendClass();
    }

    public void carInstances() {
        Car forester = new Car();
        forester.color = "Blue";
        forester.speed = 60;

        // drive
        forester.startEngine();
        forester.accelerate();

        Car audi = new Car();
        audi.color = "White";
        audi.speed = 80;

        // drive
        audi.startEngine();
        audi.accelerate();
    }
}
