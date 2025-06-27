package com.example.loggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingWithAppenders {

    private static final Logger logger = LoggerFactory.getLogger(LoggingWithAppenders.class);

    public static void main(String[] args) {

        logger.info("Application started successfully.");

        String username = "JohnDoe";
        int transactionId = 2025;

        logger.info("User {} has logged in.", username);
        logger.warn("User {} attempted to perform an unauthorized transaction.", username);
        logger.error("Transaction {} failed due to insufficient balance.", transactionId);

        logger.info("Application finished logging to console and file.");
    }
}
