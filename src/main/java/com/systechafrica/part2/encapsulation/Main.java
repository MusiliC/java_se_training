package com.systechafrica.part2.encapsulation;

import java.util.logging.Logger;



public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        Employee employee = new Employee();
        Cars cars = new Cars("BMW", "$30,000", "120 mph");

        // employee.id = 12;

        employee.setId(4);
        employee.setName("Musili");

        LOGGER.info("Name " + employee.getName());

        LOGGER.info(
                "Car name: " + cars.getName() + " price " + cars.getPrice() + " with top speed " + cars.getTopSpeed());

        // ? printing after updating the value

        LOGGER.info("After updating the new values with set method");

        cars.setPrice("$ 200,000");
        cars.setTopSpeed("200 mph");
        LOGGER.info(
                "Car name: " + cars.getName() + " price " + cars.getPrice() + " with top speed " + cars.getTopSpeed());
    }

}
