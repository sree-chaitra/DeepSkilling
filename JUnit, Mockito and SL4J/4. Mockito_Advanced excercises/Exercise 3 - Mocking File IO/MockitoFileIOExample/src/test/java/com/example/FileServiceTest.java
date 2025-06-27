package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FileServiceTest {

    @Test
    public void testServiceWithMockFileIO() {
        // Step 1: Create mock file reader and writer
        FileReader mockFileReader = mock(FileReader.class);
        FileWriter mockFileWriter = mock(FileWriter.class);

        // Step 2: Stub the file reader method
        when(mockFileReader.read()).thenReturn("Mock File Content");

        // Step 3: Create service and call method
        FileService fileService = new FileService(mockFileReader, mockFileWriter);
        String result = fileService.processFile();

        // Step 4: Verify the result
        assertEquals("Processed Mock File Content", result);

        // Step 5: Verify that the writer was called with correct data
        verify(mockFileWriter).write("Processed Mock File Content");
    }
}
