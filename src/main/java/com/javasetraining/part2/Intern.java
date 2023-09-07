package com.javasetraining.part2;

import java.util.logging.Logger;

public class Intern {

    private static final Logger LOGGER = Logger.getLogger(Intern.class.getName());

    String name;
    String number;
    String email;

    public void attendClass() {
        LOGGER.info("Attended class");
    }

    public void doAssignment() {
          LOGGER.info("Do assignment");
    }

    
}
