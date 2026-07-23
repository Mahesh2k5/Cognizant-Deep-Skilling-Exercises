import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Exercise 1: Basic Testing with JUnit
public class Exercise1_BasicTestingWithJUnit {

    public static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }

        public int subtract(int a, int b) {
            return a - b;
        }

        public int multiply(int a, int b) {
            return a * b;
        }

        public double divide(int a, int b) {
            if (b == 0) throw new IllegalArgumentException("Cannot divide by zero");
            return (double) a / b;
        }
    }

    public static class CalculatorTest {
        private final Calculator calculator = new Calculator();

        @Test
        public void testAdd() {
            assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
        }

        @Test
        public void testSubtract() {
            assertEquals(1, calculator.subtract(4, 3), "4 - 3 should equal 1");
        }

        @Test
        public void testMultiply() {
            assertEquals(12, calculator.multiply(3, 4), "3 * 4 should equal 12");
        }

        @Test
        public void testDivide() {
            assertEquals(2.0, calculator.divide(6, 3), "6 / 3 should equal 2.0");
        }

        @Test
        public void testDivideByZero() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                calculator.divide(1, 0);
            });
            assertEquals("Cannot divide by zero", exception.getMessage());
        }
    }
}
