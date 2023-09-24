package com.systechafrica.part3.logging;

import java.io.IOException;

import java.util.logging.FileHandler;

import java.util.logging.Logger;



public class FileLogging {

    private static final Logger LOGGER = Logger.getLogger(FileLogging.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
        
        FileHandler handler = new FileHandler("log.txt");
        CustomFormatter formatter = new CustomFormatter();
        LOGGER.addHandler(handler);
        handler.setFormatter(formatter);

        LOGGER.info("Info logging message\n");
        LOGGER.severe("Error logging message\n");
        LOGGER.warning("Warning logging message\n");
        test();
    }

    private static void test(){
         LOGGER.info("Info logging message test \n");
        LOGGER.severe("Error logging message test \n");
        LOGGER.warning("Warning logging message test \n");
    }
}
