package br.com.testesUnitarios;

import br.com.testesUnitarios.service.Order;
import br.com.testesUnitarios.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    private final OrderService orderService = new OrderService();
    private final UUID defaultUiid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2025, 1, 6, 21, 57, 50);


    @DisplayName("Should include random order id when no order id exists")
    @Test
    void testShouldIncludeRandonOrderId_When_NoOrderIdExists(){
        try(MockedStatic<UUID> mockedUUID = mockStatic(UUID.class)){
            mockedUUID.when(UUID::randomUUID).thenReturn(defaultUiid);
            Order result = orderService.createOrder("Macbook Pro", 2L, null);
            assertEquals(defaultUiid.toString(), result.getId());
        }
    }

    @DisplayName("Should include current time when create a new order")
    @Test
    void testShouldIncludeCurrentTime_When_CreateANewOrder(){
        try(MockedStatic<LocalDateTime> mockedUUID = mockStatic(LocalDateTime.class)){
            mockedUUID.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);
            Order result = orderService.createOrder("Macbook Pro", 2L, null);
            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }
    }
}
