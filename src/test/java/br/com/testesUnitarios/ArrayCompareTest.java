package br.com.testesUnitarios;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayCompareTest {

    @Test
    @DisplayName("Test: Array Compare")
    void testCompare_SortingArrayAndCompare_shouldCompare(){
        int[] numbers = {5, 3, 4, 1, 2};
        int[] expectedArray = {1, 2, 3, 4, 5};

        Arrays.sort(numbers);

        assertArrayEquals(expectedArray, numbers);
    }

    @Test
    @DisplayName("Test: Performance")
    // Aqui conta por segundos
    //@Timeout(1)
    //Já aqui executa na casa escolhida
    @Timeout(value = 14, unit = TimeUnit.MILLISECONDS)
    void testPerformanceMethod(){
        int[] numbers = {5, 3, 4, 1, 2};
        for (int i = 0; i < 1000000000; i++) {
            numbers[0] = i;
            Arrays.sort(numbers);
        }
    }
}
