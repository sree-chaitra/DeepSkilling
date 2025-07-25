package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ApiServiceTest {

    @Test
    public void testServiceWithMockRestClient() {
        // Step 1: Create mock REST client
        RestClient mockRestClient = mock(RestClient.class);

        // Step 2: Stub the REST client method
        when(mockRestClient.getResponse()).thenReturn("Mock Response");

        // Step 3: Create service and call method
        ApiService apiService = new ApiService(mockRestClient);
        String result = apiService.fetchData();

        // Step 4: Verify the result
        assertEquals("Fetched Mock Response", result);

        // Optional: Verify the REST call was made
        verify(mockRestClient).getResponse();
    }
}
