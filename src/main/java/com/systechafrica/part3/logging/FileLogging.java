package com.systechafrica.part3.logging;

import java.io.IOException;

import java.util.logging.FileHandler;

import java.util.logging.Logger;

public class FileLogging {

    private static final Logger LOGGER = Logger.getLogger(FileLogging.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
        setUpFileHandler();
        FileLogging app = new FileLogging();
        app.Test();

    }

    private static void setUpFileHandler() throws SecurityException, IOException {
        FileHandler handler = new FileHandler("log.txt", true);
        CustomFormatter formatter = new CustomFormatter();
        LOGGER.addHandler(handler);
        handler.setFormatter(formatter);
    }

    public void Test() {
        LOGGER.info("Trying file log handling");
    }

}
