package com.example;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MyServiceTest {

    @Test
    public void testArgumentMatching() {
        // Step 1: Create mock
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Step 2: Create service and call method with argument
        MyService service = new MyService(mockApi);
        service.processAndSend("hello");

        // Step 3: Verify that the method was called with the expected processed argument
        verify(mockApi).sendData(eq("HELLO")); // Argument matcher checks exact value
    }
}
