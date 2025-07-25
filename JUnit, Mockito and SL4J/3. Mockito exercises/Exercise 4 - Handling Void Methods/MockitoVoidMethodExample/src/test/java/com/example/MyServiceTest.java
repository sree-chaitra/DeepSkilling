package com.example;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testVoidMethod() {
        // Step 1: Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Stub the void method (optional if no special behavior)
        // doNothing() is default for void methods in Mockito

        // Step 3: Call the method
        MyService service = new MyService(mockApi);
        service.doAction("Test Message");

        // Step 4: Verify that the void method was called with the correct argument
        verify(mockApi).logMessage("Test Message");
    }
}
