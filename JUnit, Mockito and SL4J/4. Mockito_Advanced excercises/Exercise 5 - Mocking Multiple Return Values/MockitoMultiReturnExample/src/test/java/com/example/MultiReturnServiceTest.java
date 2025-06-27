package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MultiReturnServiceTest {

    @Test
    public void testServiceWithMultipleReturnValues() {
        // Step 1: Create mock repository
        Repository mockRepository = mock(Repository.class);

        // Step 2: Stub the method to return different values on consecutive calls
        when(mockRepository.getData())
            .thenReturn("First Mock Data")
            .thenReturn("Second Mock Data");

        // Step 3: Create service
        Service service = new Service(mockRepository);

        // Step 4: Call the method twice and verify results
        String firstResult = service.processData();
        String secondResult = service.processData();

        // Step 5: Assert the expected results
        assertEquals("Processed First Mock Data", firstResult);
        assertEquals("Processed Second Mock Data", secondResult);

        // Optional: Verify the repository method was called twice
        verify(mockRepository, times(2)).getData();
    }
}
