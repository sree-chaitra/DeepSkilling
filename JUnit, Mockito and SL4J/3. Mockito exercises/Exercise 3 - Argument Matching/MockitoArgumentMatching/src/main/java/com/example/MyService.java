package com.example;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void processAndSend(String input) {
        String processed = input.toUpperCase(); // Example processing
        api.sendData(processed);
    }
}
