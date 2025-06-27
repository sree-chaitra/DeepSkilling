package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVoidMethodThrowsException() throws Exception {
        // Step 1: Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Stub the void method to throw an exception
        doThrow(new RuntimeException("Deletion Failed")).when(mockApi).deleteData("123");

        // Step 3: Create service
        MyService service = new MyService(mockApi);

        // Step 4: Verify the exception is thrown when the method is called
        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.deleteRecord("123");
        });

        // Step 5: Check exception message
        assertEquals("Deletion Failed", exception.getMessage());

        // Step 6: Verify the interaction happened
        verify(mockApi).deleteData("123");
    }
}
