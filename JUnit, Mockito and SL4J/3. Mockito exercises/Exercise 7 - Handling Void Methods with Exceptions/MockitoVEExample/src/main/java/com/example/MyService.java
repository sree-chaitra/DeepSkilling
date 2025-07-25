package com.example;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void deleteRecord(String id) throws Exception {
        api.deleteData(id);
    }
}
