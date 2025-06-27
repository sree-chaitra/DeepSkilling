package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testMultipleReturns() {
        // Step 1: Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Stub the method to return different values
        when(mockApi.getData()).thenReturn("First Return", "Second Return");

        // Step 3: Use the mock in the service
        MyService service = new MyService(mockApi);

        // Step 4: Call the method multiple times and check results
        String firstCall = service.getFirstData();
        String secondCall = service.getSecondData();

        // Step 5: Assertions
        assertEquals("First Return", firstCall);
        assertEquals("Second Return", secondCall);
    }
}
