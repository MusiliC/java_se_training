package com.systechafrica.part2.classes;

import java.util.logging.Logger;

public class Intern {

    private static final Logger LOGGER = Logger.getLogger(Intern.class.getName());

    String name;
    String number;
    String email;

    public Intern (String name, String number, String email){
        this.name = name;
        this.email = email;
        this.number = number;

        this.doAssignment();
        
    }

    public Intern(){}

    

    public void attendClass() {
        LOGGER.info("Attended class");
    }

    public void doAssignment() {
          LOGGER.info("Do assignment");
    }

    
}
