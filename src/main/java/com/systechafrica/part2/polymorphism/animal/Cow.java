package com.systechafrica.part2.polymorphism.animal;

import java.util.logging.Logger;



public class Cow extends AnimalSound{

      private static final Logger LOGGER = Logger.getLogger(Cow.class.getName());

    public void sound(){
        LOGGER.info("Cow says : moo moo");
    }
}
