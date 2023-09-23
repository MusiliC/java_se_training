package com.systechafrica.part1.stringandstringbuilder;

import java.util.logging.Logger;


public class StringMethodsDemo {
    
      private static final Logger LOGGER = Logger.getLogger(StringMethodsDemo.class.getName()); 
    public static void main(String[] args) {
        String message = "Hello";

        message.concat("World");

        LOGGER.info(message);
    }
}
