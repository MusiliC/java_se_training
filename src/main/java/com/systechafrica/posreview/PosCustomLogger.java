package com.systechafrica.posreview;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class PosCustomLogger {

    public static Logger getLogger() {
        Logger LOGGER = Logger.getLogger("CustomLoggerForPos");
        // the path to log files
        
        try {
            String logFilePath = "poslogfiles/log.txt";
            // the file and appending - true
            FileHandler posFileHandler = new FileHandler(logFilePath, true);
            PosCustomFormatter posCustomFormatter = new PosCustomFormatter();
            LOGGER.addHandler(posFileHandler);
            posFileHandler.setFormatter(posCustomFormatter);
           
        } catch (SecurityException e) {
            LOGGER.info("Security permission exception " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.info("I/O permission exception " + e.getMessage());
            e.printStackTrace();
        }
        return LOGGER;
    }
}
