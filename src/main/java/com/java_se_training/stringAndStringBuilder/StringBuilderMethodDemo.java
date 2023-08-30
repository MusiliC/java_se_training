package com.java_se_training.stringAndStringBuilder;

import java.util.logging.Logger;



public class StringBuilderMethodDemo {
    
      private static final Logger LOGGER = Logger.getLogger(StringBuilderMethodDemo.class.getName()); 
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(100);

        String str = "";

       LOGGER.info(" " + str.equals(sb.toString()));
    }
}
