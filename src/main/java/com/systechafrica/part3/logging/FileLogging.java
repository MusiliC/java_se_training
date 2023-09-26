package com.systechafrica.part3.logging;

import java.io.IOException;

import java.util.logging.FileHandler;

import java.util.logging.Logger;



public class FileLogging {

    private static final Logger LOGGER = Logger.getLogger(FileLogging.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
        
        FileHandler handler = new FileHandler("log.txt", true);
        CustomFormatter formatter = new CustomFormatter();
        LOGGER.addHandler(handler);
        handler.setFormatter(formatter);

        LOGGER.info("Appending new logs\n");
        LOGGER.severe("Error appending new logs\n");
        LOGGER.warning("Warning appending new logs to existing\n");
        
    }


}
