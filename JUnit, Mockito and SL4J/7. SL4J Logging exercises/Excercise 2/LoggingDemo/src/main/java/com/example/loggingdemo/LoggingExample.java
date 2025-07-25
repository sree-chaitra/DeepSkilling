package com.example.loggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        String username = "JohnDoe";
        int userId = 101;

        // Parameterized logging examples
        logger.info("User with username: {} and ID: {} has logged in.", username, userId);

        int items = 5;
        double price = 250.75;
        logger.info("User {} purchased {} items worth ${}.", username, items, price);

        logger.debug("Debugging user login process for user ID: {}", userId);

        logger.warn("User {} attempted to access restricted resource.", username);

        logger.error("Error occurred while processing user ID: {}", userId);
    }
}
