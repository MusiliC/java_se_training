package com.javasetraining.stringandstringbuilder;

import java.util.logging.Logger;

public class StudentClass {

            private String firstName;
        private String secondName;
        private String emailName;
    
  private static final Logger LOGGER = Logger.getLogger(StudentClass.class.getName()); 

  public String getFullName(){
    StringBuilder sb = new StringBuilder();

    sb.append(firstName)
    .append(" ")
    .append(secondName)
    .append(" ")
    .append(emailName);

    return sb.toString();
  }
    public static void main(String[] args) {
        StudentClass app = new StudentClass();

        String fulName = app.getFullName();
        LOGGER.info(fulName);
    }
}
