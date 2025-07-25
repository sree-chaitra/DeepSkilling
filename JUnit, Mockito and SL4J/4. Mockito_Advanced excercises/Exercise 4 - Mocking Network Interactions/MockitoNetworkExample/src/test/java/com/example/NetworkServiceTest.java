package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NetworkServiceTest {

    @Test
    public void testServiceWithMockNetworkClient() {
        // Step 1: Create mock network client
        NetworkClient mockNetworkClient = mock(NetworkClient.class);

        // Step 2: Stub the network client method
        when(mockNetworkClient.connect()).thenReturn("Mock Connection");

        // Step 3: Create service and call method
        NetworkService networkService = new NetworkService(mockNetworkClient);
        String result = networkService.connectToServer();

        // Step 4: Verify the result
        assertEquals("Connected to Mock Connection", result);

        // Step 5: Verify the interaction
        verify(mockNetworkClient).connect();
    }
}
