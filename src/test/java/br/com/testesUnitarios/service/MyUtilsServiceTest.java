package br.com.testesUnitarios.service;

import br.com.testesUnitarios.service.staticwithparams.MyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyUtilsServiceTest {

    @Test
    @DisplayName("Test: Should mock method with params and the return be equals!")
    void testMockStaticMethodWithParams_WhenHaveParams_Then_ShouldBeEqualsTheReturn(){
        try(MockedStatic<MyUtils> mockedStatic = mockStatic(MyUtils.class)) {
            mockedStatic.when(
                    () -> MyUtils.getWelcomeMessage(
                            eq("Erudio"),
                            anyBoolean()
                    )
            ).thenReturn("Howdy Erudio!");

            String messageReturnedFromWelcomeMessage = MyUtils.getWelcomeMessage("Erudio", false);
            assertEquals("Howdy Erudio!", messageReturnedFromWelcomeMessage);
        }
    }
}
