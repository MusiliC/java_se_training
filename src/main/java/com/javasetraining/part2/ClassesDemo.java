package com.javasetraining.part2;

public class ClassesDemo {

    public static void main(String[] args) {
        ClassesDemo app = new ClassesDemo();

        app.interns();
        app.carInstances();
    }

    public void interns() {
        Intern musili = new Intern();

        musili.name = "Musili Brian";
        musili.email = "musili@gmail.com";
        musili.name = "07112233";

        musili.doAssignment();
        musili.attendClass();

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
