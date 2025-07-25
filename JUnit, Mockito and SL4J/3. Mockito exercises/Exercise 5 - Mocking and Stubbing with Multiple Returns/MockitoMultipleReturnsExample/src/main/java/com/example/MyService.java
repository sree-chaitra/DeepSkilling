package com.example;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String getFirstData() {
        return api.getData();
    }

    public String getSecondData() {
        return api.getData();
    }
}
