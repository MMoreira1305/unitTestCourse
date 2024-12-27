package br.com.testesUnitarios;
import br.com.testesUnitarios.math.SimpleMath;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Simple math")
public class SimpleMathTestS4 {

    SimpleMath math;

    @BeforeEach
    void instantiableSimpleMath(){
        System.out.println("Running method of BeforeEach");
        math = new SimpleMath();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Pelé", "Senna", "Keith Moon"})
    void testValueSource(String firstName){
        System.out.println(firstName);
        assertNotNull(firstName);
    }

    @DisplayName("Test: The division of 12 and 2 should return 6")
    @ParameterizedTest
   // @MethodSource("testDivisionInputParameters")
    @CsvSource({
            "6.2, 2, 3.1",
            "14, 2, 7",
            "20, 5, 4"
    })
    void testDivision(double firstNumber, double secondNumber, double expected){

        // When / Act
        Double result = math.division(firstNumber, secondNumber);

        // Then / Assert
        assertEquals(expected, result, 2D,
                () -> firstNumber + "+" + secondNumber +
                " did not produce the expected result: " + expected);
        assertNotEquals(6.5D, result);
        assertNotNull(result);
    }

    /*
    public static Stream<Arguments> testDivisionInputParameters(){
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(14D, 2D, 7D),
                Arguments.of(20D, 5D, 4D)
        );
    }*/
}
