package com.example;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void doAction(String message) {
        // Some action performed here
        api.logMessage(message);
    }
}
