package com.systechafrica.stringandstringbuilder;

import java.util.logging.Logger;



public class StringBuilderMethodDemo {
    
      private static final Logger LOGGER = Logger.getLogger(StringBuilderMethodDemo.class.getName()); 
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(100);

         Class<?> dataTypeClass = sb.getClass();
         LOGGER.info("Data type is " + dataTypeClass);

        String str = "";

       LOGGER.info(" " + str.toString().equals(sb.toString()));
    }
}
