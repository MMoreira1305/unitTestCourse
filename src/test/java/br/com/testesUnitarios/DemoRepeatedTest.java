package br.com.testesUnitarios;
import br.com.testesUnitarios.math.SimpleMath;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DemoRepeatedTest {

    SimpleMath math;

    @BeforeEach
    void instantiableSimpleMath(){
        System.out.println("Running method of BeforeEach");
        math = new SimpleMath();
    }

    @RepeatedTest(value = 3,
                  name = "{displayName}. Repetition "
                        + "{currentRepetition} of {totalRepetitions}!"
    )
    @DisplayName("Test: Division by zero")
    void testDivision_WhenFirstNumberIsDividedByZero_ShouldThrowException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo
    ){
        System.out.println("Repetition number: " + repetitionInfo.getCurrentRepetition()
                            + " of " + repetitionInfo.getTotalRepetitions());

        System.out.println("Running: " +
                testInfo.getTestMethod().orElseThrow(
                        () -> new RuntimeException("Error to access name of method"))
                .getName());

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
}
