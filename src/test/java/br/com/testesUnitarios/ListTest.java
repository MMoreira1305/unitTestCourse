package br.com.testesUnitarios;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ListTest {

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturn10(){
        // Given / Arrange
        List list = mock(List.class);
        when(list.size()).thenReturn(10);

        // When / Act & Then / Assert
        assertEquals(10, list.size());
    }

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturnMultipleValues(){
        // Given / Arrange
        List list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);

        // When / Act & Then / Assert
        assertEquals(10, list.size());
        assertEquals(20, list.size());
    }

    @Test
    void testMocckingList_When_GetIsCalled_ShouldReturnErudio(){
        // Given / Arrange
        var list = mock(List.class);
        when(list.get(0)).thenReturn("Erudio");

        // When / Act & Then / Assert
        assertEquals("Erudio", list.get(0));
    }

    @Test
    void testMocckingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnErudio(){
        // Given / Arrange
        var list = mock(List.class);
        when(list.get(anyInt())).thenThrow(
                new RuntimeException("Error: Non possible get anyInt()"));

        // When / Act & Then / Assert
        assertThrows(
                RuntimeException.class,
                () -> {
                    // When / Act
                    list.get(anyInt());
                },
                () -> "Should throw RuntimeException with this message: Error: Non possible get anyInt()"
                );
    }
}
