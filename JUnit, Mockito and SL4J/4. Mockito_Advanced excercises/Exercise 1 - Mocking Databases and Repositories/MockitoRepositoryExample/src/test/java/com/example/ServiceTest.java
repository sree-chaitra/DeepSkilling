package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ServiceTest {

    @Test
    public void testServiceWithMockRepository() {
        // Step 1: Create mock repository
        Repository mockRepository = mock(Repository.class);

        // Step 2: Stub the repository method
        when(mockRepository.getData()).thenReturn("Mock Data");

        // Step 3: Pass mock to service and test
        Service service = new Service(mockRepository);
        String result = service.processData();

        // Step 4: Verify result
        assertEquals("Processed Mock Data", result);

        // Optional: Verify repository interaction
        verify(mockRepository).getData();
    }
}
