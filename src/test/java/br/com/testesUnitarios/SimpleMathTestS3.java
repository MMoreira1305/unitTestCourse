package br.com.testesUnitarios;
import br.com.testesUnitarios.math.SimpleMath;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Simple math")
public class SimpleMathTestS3 {

    SimpleMath math;

    @BeforeAll
    static void setup(){
        System.out.println("Running method of setup");
    }

    @AfterAll
    static void cleanUp(){
        System.out.println("Running method of cleanUp");
    }

    @BeforeEach
    void instantiableSimpleMath(){
        System.out.println("Running method of BeforeEach");
        math = new SimpleMath();
    }

    @AfterEach
    void afterEach(){
        System.out.println("Running method of AfterEach");
    }

    @Test
    @DisplayName("Test: Division by zero")
    void testDivision_WhenFirstNumberIsDividedByZero_ShouldThrowException(){
        // Given / Arrange
        double firstNumber = 6.2D;
        double secondNumber = 0;

        var expectedMessage = "Impossible to Divide by Zero!";

        ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
                // When
                math.division(firstNumber, secondNumber);
        }, () -> "Division by Zero should throw ArithmeticException!");
        // Then
        // Os dois ao mesmo tempo por conta da expressão lambda.

        assertEquals(expectedMessage, actual.getMessage(), () -> "Unexpected exception message!");
    }

    @Test
    @DisplayName("Test: The sum of 6,2 and 2,0 should return 8,2")
    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    void testSum_WhenSixDot2IsAddedByTwo_ShouldReturnEightDotTwo(){

        System.out.println("Test: The sum of 6,2 and 2,0 should return 8,2");

        // AAA - Arrange, Act, Assert
        // Given / Arrange
        double firstNumber = 6.2D;
        double secondNumber = 2.0D;
        double expected = 8.2D;

        // When / Act
        Double result = math.sum(firstNumber, secondNumber);

        // Then / Assert
        assertEquals(expected, result, () -> firstNumber + "+" + secondNumber +
                " did not produce the expected result: " + expected);
        assertNotEquals(9.2D, result);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test: The subtract of 6 and 2 should return 4")
    void testSubtract(){

        System.out.println("Test: The subtract of 6 and 2 should return 4");

        // Given / Arrange
        double firstNumber = 6.0D;
        double secondNumber = 2.0D;
        double expected = 4.0D;

        // When / Act
        Double result = math.subtraction(firstNumber, secondNumber);

        // Then / Assert
        assertEquals(expected, result, () -> firstNumber + "+" + secondNumber +
                " did not produce the expected result: " + expected);
        assertNotEquals(9.2D, result);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test: The multiplication of 4 and 2 should return 8")
    void testMultiplication(){

        System.out.println("Test: The multiplication of 4 and 2 should return 8");

        // Given / Arrange
        double firstNumber = 4.0D;
        double secondNumber = 2.0D;
        double expected = 8.0D;

        // When / Act
        Double result = math.multiplication(firstNumber, secondNumber);

        // Then / Assert
        assertEquals(expected, result, () -> firstNumber + "+" + secondNumber +
                " did not produce the expected result: " + expected);
        assertNotEquals(9.2D, result);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test: The division of 12 and 2 should return 6")
    void testDivision(){

        System.out.println("Test: The division of 12 and 2 should return 6");

        // Given / Arrange
        double expected = 6.0D;
        double firstNumber = 12.0D;
        double secondNumber = 2.0D;

        // When / Act
        Double result = math.division(firstNumber, secondNumber);

        // Then / Assert
        assertEquals(expected, result, () -> firstNumber + "+" + secondNumber +
                " did not produce the expected result: " + expected);
        assertNotEquals(6.5D, result);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test: The mean of 9 + 3 should return 6")
    void testMean(){

        System.out.println("Test: The mean of 9 + 3 should return 6");

        // Given / Arrange
        double firstNumber = 9.0D;
        double secondNumber = 3.0D;
        double expected = 6.0D;

        // When / Act
        Double result = math.mean(firstNumber, secondNumber);

        // Then / Assert
        assertEquals(expected, result, () -> firstNumber + "+" + secondNumber +
                " did not produce the expected result: " + expected);
        assertNotEquals(7.0D, result);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Test: The squareroot of 144 should return 12")
    void testSquareRoot(){

        System.out.println("Test: The squareroot of 144 should return 12");

        // Given / Arrange
        double number = 144D;
        double expected = 12D;

        // When / Act
        Double result = math.squareRoot(number);

        // Then / Assert
        assertEquals(expected, result, () -> result + " did not produce the expected result: " + expected);
        assertNotEquals(14D, result);
        assertNotNull(result);
    }
}
