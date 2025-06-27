package calculator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calc;

    // Arrange: Setup before each test
    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Setup done");
    }

    // Act and Assert: Test method
    @Test
    public void testAdd() {
        // Act
        int result = calc.add(2, 3);

        // Assert
        assertEquals(5, result);
    }

    // Teardown after each test
    @After
    public void tearDown() {
        System.out.println("Teardown done");
    }
}
